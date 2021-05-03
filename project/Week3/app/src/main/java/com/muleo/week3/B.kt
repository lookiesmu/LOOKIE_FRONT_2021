package com.muleo.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muleo.week3.databinding.ActivityBBinding

class B : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!this::binding.isInitialized) {
            binding = ActivityBBinding.inflate(layoutInflater)
        }
        binding.apply {
            backButton.setOnClickListener {
                finish()
            }
        }
        setContentView(binding.root)
    }
}