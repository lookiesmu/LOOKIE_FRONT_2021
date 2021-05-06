package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a_b_cbutton.*

class ABCbutton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_b_cbutton)


        a.setOnClickListener{
            val intent1= Intent(this@ABCbutton, AActivity::class.java)
            intent1.apply {
                this.putExtra("number", 1)
            } // putExtra : intent에 정보를 실어서 보냄.
            startActivity(intent1)
        }
        b.setOnClickListener{
            val intent2= Intent(this@ABCbutton, BActivity::class.java)
            intent2.apply {
                this.putExtra("number", 2)
            } // putExtra : intent에 정보를 실어서 보냄.
            startActivity(intent2)
        }
        c.setOnClickListener{
            val intent3= Intent(this@ABCbutton, CActivity::class.java)
            intent3.apply {
                this.putExtra("number", 3)
            } // putExtra : intent에 정보를 실어서 보냄.
            startActivity(intent3)
        }
    }
}