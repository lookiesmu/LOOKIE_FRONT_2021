package com.example.cws_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_c.*
import kotlinx.android.synthetic.main.activity_main.*

class CActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        ButtonCC.setOnClickListener {
            val intentCC = Intent(this@CActivity, MainActivity::class.java)
            startActivity(intentCC)
        }
    }
}