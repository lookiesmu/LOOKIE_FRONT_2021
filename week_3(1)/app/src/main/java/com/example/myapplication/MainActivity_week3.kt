package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity_week3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        change_activity1.setOnClickListener {
            val intent = Intent(this@MainActivity_week3, AActivity_week3::class.java)
            startActivity(intent)
        }

        change_activity2.setOnClickListener {
            val intent = Intent(this@MainActivity_week3, BActivity_week3::class.java)
            startActivity(intent)
        }

        change_activity3.setOnClickListener {
            val intent = Intent(this@MainActivity_week3, CActivity_week3::class.java)
            startActivity(intent)
        }
    }
}