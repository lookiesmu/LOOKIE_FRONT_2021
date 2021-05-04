package com.example.cws_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        ButtonBB.setOnClickListener {
            val intentBB = Intent(this@BActivity, MainActivity::class.java)
            startActivity(intentBB)
        }
    }
}