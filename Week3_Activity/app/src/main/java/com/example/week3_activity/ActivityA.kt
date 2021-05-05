package com.example.week3_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)

        val resultA : Button = findViewById(R.id.backA)
        resultA.setOnClickListener {
            val resultIntent = Intent()
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}