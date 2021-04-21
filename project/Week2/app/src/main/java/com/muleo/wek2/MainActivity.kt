package com.muleo.wek2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onStart(view: View) {
        startActivity(Intent(this, OverviewActivity::class.java).apply {
            val query = findViewById<EditText>(R.id.search_editText).text.toString()
            putExtra("query", query)
        })
    }

}