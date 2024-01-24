package com.example.ejercicio3pmm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio3pmm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SQL
        val dbHelper = DatabaseHelper(this)

        binding.RecogerBtn.setOnClickListener {
            val intent = Intent(this, MochilaActivity::class.java)
            startActivity(intent)
        }
    }
}