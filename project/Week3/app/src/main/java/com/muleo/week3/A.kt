package com.muleo.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muleo.week3.databinding.ActivityABinding
import com.muleo.week3.databinding.ActivityMainBinding

class A : AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!this::binding.isInitialized) {
            binding = ActivityABinding.inflate(layoutInflater)
        }
        binding.apply {
            backButton.setOnClickListener{
                finish()
            }
        }
        setContentView(binding.root)
    }
}