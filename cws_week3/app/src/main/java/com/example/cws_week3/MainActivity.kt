package com.example.cws_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButtonA.setOnClickListener {
            val intentA = Intent(this@MainActivity, AActivity::class.java)
            startActivity(intentA)
        }

        ButtonB.setOnClickListener {
            val intentB = Intent(this@MainActivity, BActivity::class.java)
            startActivity(intentB)
        }

        ButtonC.setOnClickListener {
            val intentC = Intent(this@MainActivity, CActivity::class.java)
            startActivity(intentC)
        }

    }
}