package com.muleo.week3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muleo.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!this::binding.isInitialized) {
            binding = ActivityMainBinding.inflate(layoutInflater)
        }
        binding.apply {
            buttonA.setOnClickListener {
                val intent = Intent(this@MainActivity, A::class.java)
                startActivity(intent)
            }
            buttonB.setOnClickListener {
                val intent = Intent(this@MainActivity, B::class.java)
                startActivity(intent)
            }
            buttonC.setOnClickListener {
                val intent = Intent(this@MainActivity, C::class.java)
                startActivity(intent)
            }
        }
        setContentView(binding.root)
    }
}