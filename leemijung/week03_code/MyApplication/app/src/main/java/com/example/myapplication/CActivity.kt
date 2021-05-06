package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        back.setOnClickListener{
            val number1 = intent.getIntExtra("number1", 0)
            Log.d("number", "" + number1)

            finish()
        }
    }
}