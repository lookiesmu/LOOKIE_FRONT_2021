package com.example.cws_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        ButtonAA.setOnClickListener {
            val intentAA= Intent(this@AActivity, MainActivity::class.java)
            startActivity(intentAA)
        }
    }
}