package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_b.*

class BActivity_week3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        activity2.setOnClickListener {
            val intent = Intent(this@BActivity_week3, MainActivity_week3::class.java)
            startActivity(intent)
        }
    }
}