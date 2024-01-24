package com.example.ejercicio3pmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio3pmm.databinding.ActivityMochilaBinding

class MochilaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMochilaBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMochilaBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val imageViews = arrayOf(

            binding.imageView2,
            binding.imageView3,
            binding.imageView4,
            binding.imageView5,
            binding.imageView6,
            binding.imageView7,
            binding.imageView8,
            binding.imageView9
        )
        imageViews.forEach { it.visibility = View.GONE }



    }







}