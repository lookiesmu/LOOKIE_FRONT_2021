package com.muleo.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muleo.week3.databinding.ActivityCBinding

class C : AppCompatActivity() {
    private lateinit var binding: ActivityCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!this::binding.isInitialized) {
            binding = ActivityCBinding.inflate(layoutInflater)
        }
        binding.apply {
            backButton.setOnClickListener {
                finish()
            }
        }
        setContentView(binding.root)
    }
}