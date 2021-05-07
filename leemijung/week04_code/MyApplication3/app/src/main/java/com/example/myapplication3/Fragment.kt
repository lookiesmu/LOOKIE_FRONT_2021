package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class Fragment : AppCompatActivity() , FragmentOne.OnDataPassListener{

    override fun onDataPass(data: String?) {
        Log.d("pass", ""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        //붙이는 것과 떼는 것을 같게 설정해야 하기 때문에 여기에 변수 선언
        val fragmentOne:FragmentOne= FragmentOne()

        // 프라그먼트에 data를 넣어주는 방법 - bundle 사용
        val bundle:Bundle=Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments=bundle  // 할당

        button.setOnClickListener{
            // 프라그먼트를 동적으로 작동하는 방법
            // 프라그먼트 붙이는 방법 replace/add
            val fragmentManager:FragmentManager=supportFragmentManager

            // Transaction 만들기
            // = 작업의 단위 -> 시작과 끝이 존재한다.
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit()

            // 끝을 내는 방법 2가지
            // 1. commit    -> 시간 될 때 해 (보통 사용, 좀더 안정적)
            // 2. commitnow -> 지금 당장해
        }

        button2.setOnClickListener{
            // 프라그먼트 떼기
            // 프로그먼트 remove/detach 하는 방법
            // remove: 다시 됨
            // detach: 다시 안됨
            val fragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
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