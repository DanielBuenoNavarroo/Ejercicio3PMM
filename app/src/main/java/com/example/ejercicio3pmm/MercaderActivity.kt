package com.example.ejercicio3pmm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio3pmm.databinding.ActivityMercaderBinding

class MercaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMercaderBinding
    private lateinit var listaArticulos: List<Articulos>
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imagenObj = binding.imageView12
        val mochilote = binding.imageView2
        val textPeso = binding.textPeso
        val textNombre = binding.textNombre
        val textTipo = binding.textTipo
        val atrasBtn = binding.buttonatras
        val adelanteBtn = binding.buttonadelante
        binding.imageView.visibility=View.VISIBLE
        mochilote.visibility= View.INVISIBLE
        imagenObj.visibility=View.INVISIBLE
        textPeso.visibility=View.INVISIBLE
        textNombre.visibility=View.INVISIBLE
        textTipo.visibility=View.INVISIBLE
        atrasBtn.visibility=View.INVISIBLE
        adelanteBtn.visibility=View.INVISIBLE

        //INSERTAR DATOS:
        val dbHelper = ObjetosAleatorios(this)
        listaArticulos = dbHelper.getArticulos()
        dbHelper.close()



        val comerciarBtn = binding.ComerciarBtn
        val continuarBtn = binding.ContinuarBtn

        val btns = arrayOf(
            comerciarBtn,
            continuarBtn
        )

        val comprarBtn = binding.ComprarBtn
        val venderBtn = binding.VenderBtn
        val cancelarBtn = binding.CancelarBtn


        val btns2 = arrayOf(
            comprarBtn,
            venderBtn,
            cancelarBtn,
            atrasBtn,
            adelanteBtn,
            imagenObj,
            textPeso,
            textNombre,
            textTipo

        )

        btns2.forEach { it.visibility = View.INVISIBLE }

        comerciarBtn.setOnClickListener {
            binding.imageView10.visibility= View.VISIBLE
            binding.imageView.visibility= View.INVISIBLE
            val articulo = listaArticulos[currentIndex]
            btns.forEach { it.visibility = View.INVISIBLE }
            btns2.forEach { it.visibility = View.VISIBLE }
            var objeto = listaArticulos.random()
            imagenObj.setImageResource(objeto.getUri())
            binding.textPeso.text = articulo.getPrecio().toString()
            binding.textNombre.text = articulo.getNombre().toString()
            binding.textTipo.text = articulo.getTipoArticulo().toString()
        }

        comprarBtn.setOnClickListener {


        }

        continuarBtn.setOnClickListener {
            btns.forEach { it.visibility = View.INVISIBLE }
            btns2.forEach { it.visibility = View.INVISIBLE }
            binding.imageView.visibility= View.INVISIBLE
            binding.textView.visibility=View.INVISIBLE
            binding.imageView10.visibility=View.INVISIBLE
            binding.holapedro.visibility=View.VISIBLE
        }

        binding.buttonadelante.setOnClickListener {
            siguiente()
        }

        binding.buttonatras.setOnClickListener {
            anterior()
        }

        venderBtn.setOnClickListener {
            mochilote.visibility= View.VISIBLE
            binding.imageView10.visibility= View.INVISIBLE




        }


        cancelarBtn.setOnClickListener {
            btns.forEach { it.visibility = View.VISIBLE }
            btns2.forEach { it.visibility = View.INVISIBLE }
            binding.imageView10.visibility= View.INVISIBLE
            binding.imageView.visibility= View.VISIBLE


        }

    }

    private fun mostrarArticuloActual() {
        val articulo = listaArticulos[currentIndex]
        binding.imageView12.setImageResource(articulo.getUri())
        binding.textPeso.text = articulo.getPrecio().toString()
        binding.textNombre.text = articulo.getNombre().toString()
        binding.textTipo.text = articulo.getTipoArticulo().toString()
    }

    private fun anterior(){
        if (currentIndex > 0) {
            currentIndex--
            mostrarArticuloActual()
        }

    }

    private fun siguiente(){
        if (currentIndex < listaArticulos.size - 1) {
            currentIndex++
            mostrarArticuloActual()
        }

    }
}