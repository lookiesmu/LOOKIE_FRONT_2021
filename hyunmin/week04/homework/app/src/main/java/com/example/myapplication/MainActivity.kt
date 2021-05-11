package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("life_cycle", "onCreate")

        button1.setOnClickListener {
            val fragment1: Fragment1 = Fragment1()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment1)
            fragmentTransaction.commit()
        }

        button2.setOnClickListener {
            val fragment2: Fragment2 = Fragment2()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment2)
            fragmentTransaction.commit()
        }

        button3.setOnClickListener {
            val fragment3: Fragment3 = Fragment3()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment3)
            fragmentTransaction.commit()
        }

        button4.setOnClickListener {
            val fragment4: Fragment4 = Fragment4()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment4)
            fragmentTransaction.commit()
        }
    }
}