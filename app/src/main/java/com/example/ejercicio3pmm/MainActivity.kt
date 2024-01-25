package com.example.ejercicio3pmm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio3pmm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mochila = Mochila(100)

        val dbHelper = ObjetosAleatorios(this)
        val listaArticulos = dbHelper.getArticulos()
        dbHelper.close()

        val imagenObjeto = binding.imagenObjeto
        var objeto = listaArticulos.random()
        imagenObjeto.setImageResource(objeto.getUri())

        binding.RecogerBtn.setOnClickListener {
            if (mochila.getPesoMochila() - objeto.getPeso() > 0){
                mochila.addArticulo(objeto)
                Toast.makeText(this, "${objeto.getNombre()} + 1\n Peso restante: ${mochila.getPesoMochila()}", Toast.LENGTH_SHORT).show()
                objeto = listaArticulos.random()
                imagenObjeto.setImageResource(objeto.getUri())
            }else{
                Toast.makeText(this, "Has superado el peso máximo de tu mochila", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ContinuarBtn.setOnClickListener {
            val intent = Intent(this, MercaderActivity::class.java)
            startActivity(intent)
        }

    }
}