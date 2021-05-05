package com.example.week3_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actA : Button = findViewById(R.id.activityA)
        val actB : Button = findViewById(R.id.activityB)
        val actC : Button = findViewById(R.id.activityC)

        actA.setOnClickListener{
            val intent = Intent(this@MainActivity, ActivityA::class.java)
            startActivity(intent)
        }
        actB.setOnClickListener{
            val intent = Intent(this@MainActivity, ActivityB::class.java)
            startActivity(intent)
        }
        actC.setOnClickListener{
            val intent = Intent(this@MainActivity, ActivityC::class.java)
            startActivity(intent)
        }

    }
}