package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_main3.*

class AActivity_week3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        activity1.setOnClickListener {
            val intent = Intent(this@AActivity_week3, MainActivity_week3::class.java)
            startActivity(intent)
        }
    }
}