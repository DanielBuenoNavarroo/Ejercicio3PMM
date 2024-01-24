package com.example.ejercicio3pmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio3pmm.databinding.ActivityMercaderBinding

class MercaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btns = arrayOf(
        binding.ComprarBtn,
        binding.VenderBtn,
        binding.CancelarBtn
        )
        btns.forEach { it.visibility = View.INVISIBLE }




    }
}