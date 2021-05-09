package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_c.*

class CActivity_week3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        activity3.setOnClickListener {
            val intent = Intent(this@CActivity_week3, MainActivity_week3::class.java)
            startActivity(intent)
        }
    }
}