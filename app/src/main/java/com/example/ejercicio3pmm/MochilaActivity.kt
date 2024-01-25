package com.example.ejercicio3pmm

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio3pmm.databinding.ActivityMochilaBinding

class MochilaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMochilaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMochilaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageViews = arrayOf(
            binding.imageView1,
            binding.imageView2,
            binding.imageView3,
            binding.imageView4,
            binding.imageView5,
            binding.imageView6,
            binding.imageView7,
            binding.imageView8,
            binding.imageView9
        )
        val dbHelper = DatabaseHelper(this)
        val listaArticulos = dbHelper.getArticulos()
        Log.i("lista", listaArticulos.toString())

        for (i in imageViews.indices) {
            // Aquí es posible que desees verificar que i esté dentro del rango de listaArticulos
            if (i < listaArticulos.size) {
                imageViews[i].setImageResource(listaArticulos[i].getUri())
            } else {
                // En caso de que la listaArticulos sea más corta que la cantidad de imageViews
                imageViews[i].visibility = View.INVISIBLE
            }
        }
    }
}