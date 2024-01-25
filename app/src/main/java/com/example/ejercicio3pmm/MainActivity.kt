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

        //INSERTAR DATOS:
        insertarArticulos()
        val dbHelper = DatabaseHelper(this)
        val listaArticulos = dbHelper.getArticulos()
        dbHelper.close()

        val imagenObjeto = binding.imagenObjeto
        var objeto = listaArticulos.random()
        imagenObjeto.setImageResource(objeto.getUri())

        binding.RecogerBtn.setOnClickListener {
            Toast.makeText(this, "${objeto.getNombre()} + 1", Toast.LENGTH_SHORT).show()
            objeto = listaArticulos.random()
            imagenObjeto.setImageResource(objeto.getUri())
        }


        binding.ContinuarBtn.setOnClickListener {
            val intent = Intent(this, MercaderActivity::class.java)
            startActivity(intent)
        }

    }

    private fun insertarArticulos() {
        val dbHelper = DatabaseHelper(this)
        dbHelper.borrarBaseDeDatos()
        val listaArticulos = mutableListOf(
            Articulo("amuleto", "no c", 15, R.drawable.amuleto),
            Articulo("baston", "no c", 15, R.drawable.baston),
            Articulo("daga", "no c", 15, R.drawable.daga),
            Articulo("grimorio", "no c", 15, R.drawable.grimorio),
            Articulo("huevo", "no c", 15, R.drawable.huevo),
            Articulo("mapa", "no c", 15, R.drawable.mapa),
            Articulo("orbe", "no c", 15, R.drawable.orbe),
            Articulo("pergaminos", "no c", 15, R.drawable.pergaminos),
            Articulo("pocion", "no c", 15, R.drawable.pocion)
        )
        listaArticulos.forEach { dbHelper.insertarArticulo(it) }
        dbHelper.close()
    }
}