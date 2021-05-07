package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonone: button1=button1()
        val buttontwo: button2=button2()
        val buttonthree: button3=button3()
        val buttonfour: button4=button4()

        button1.setOnClickListener{
            val fragmentManager: FragmentManager =supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, buttonone)
            fragmentTransaction.commit()
        }

        button2.setOnClickListener{
            val fragmentManager: FragmentManager =supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, buttontwo)
            fragmentTransaction.commit()
        }

        button3.setOnClickListener{
            val fragmentManager: FragmentManager =supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, buttonthree)
            fragmentTransaction.commit()
        }

        button4.setOnClickListener{
            val fragmentManager: FragmentManager =supportFragmentManager

            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, buttonfour)
            fragmentTransaction.commit()
        }

        Log.d("life_cycle", "onCreate")

    }
    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }

}