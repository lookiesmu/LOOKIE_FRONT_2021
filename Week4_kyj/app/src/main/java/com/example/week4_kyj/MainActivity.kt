package com.example.week4_kyj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.week4_kyj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val oneFragment : OneFragment = OneFragment()//생성
        binding.button1.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, oneFragment)
            fragmentTransaction.commit()//end
        }

        val twoFragment : TwoFragment = TwoFragment()//생성
        binding.button2.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, twoFragment)
            fragmentTransaction.commit()//end
        }

        val threeFragment : ThreeFragment = ThreeFragment()//생성
        binding.button3.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, threeFragment)
            fragmentTransaction.commit()//end
        }

        val fourFragment : FourFragment = FourFragment()//생성
        binding.button4.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fourFragment)
            fragmentTransaction.commit()//end
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life_cycle","onDestroy")
    }
}