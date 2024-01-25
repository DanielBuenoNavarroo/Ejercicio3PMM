package com.example.ejercicio3pmm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio3pmm.databinding.ActivityMercaderBinding

class MercaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
            cancelarBtn
        )
        btns2.forEach { it.visibility = View.INVISIBLE }

        comerciarBtn.setOnClickListener {
            btns.forEach { it.visibility = View.INVISIBLE }
            btns2.forEach { it.visibility = View.VISIBLE }
        }

        comprarBtn.setOnClickListener {
            intent = Intent(this@MercaderActivity, MochilaActivity::class.java)
            startActivity(intent)
        }

    }
}