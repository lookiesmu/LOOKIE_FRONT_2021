package com.example.week3_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val resultC : Button = findViewById(R.id.backC)
        resultC.setOnClickListener {
            val resultIntent = Intent()
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}