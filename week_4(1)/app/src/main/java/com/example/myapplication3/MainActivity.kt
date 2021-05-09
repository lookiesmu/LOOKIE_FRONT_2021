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
        Log.d("life_cycle" ,"onCreate")

        button.setOnClickListener {
            val fragmentOne : FragmentOneweek4 = FragmentOneweek4()
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }
        button2.setOnClickListener {
            val fragmentTwo : FragmentTwoweek4 = FragmentTwoweek4()
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentTwo)
            fragmentTransaction.commit()
        }
        button3.setOnClickListener {
            val fragmentThree : FragmentThreeweek4 = FragmentThreeweek4()
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentThree)
            fragmentTransaction.commit()
        }
        button4.setOnClickListener {
            val fragmentFour : FragmentFourweek4 = FragmentFourweek4()
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentFour)
            fragmentTransaction.commit()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("life_cycle" ,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle" ,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle" ,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle" ,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle" ,"onDestroy")
    }
}
