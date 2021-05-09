
package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateCar : Car
    class Car(var number : Int) {

    }


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int =10
        val number1 : Int? = null

        //개발자가 null이 아님을 보장
        //*****추천하지 않음....
        var number5 :Int = number1!! +10



  //      val number3 = number? + number1
        val number3 = number1?.plus(number)
        Log.d("number","number3 : " +number3)
        Log.d("number","number3 : " +number3)

        //***삼항연산자( 앞에꺼가 Null이 아니면 뒤에 것을 넣겠다) -> ***엘비스 연산자(?:)
        // 넙버원이 널이 아니면 넘버원이 넘버포에 들어가고, 널이면 10이 들어감
        //Null safety 를 위한 도구
        val number4 = number1 ?: 10
        Log.d("number","number4 : " +number4)

        //lateinit    --------------------> 추천하지않음... 사용할거면 사용전에 반드시 초기화가 되었는지 확인
        lateCar = Car(10)
        Log.d("number", "late number : " + lateCar.number)

    }

    fun plus (a: Int, b: Int?): Int{
        if(b !=null) return a+b
        else return a
    }
    fun plus2(a: Int, b: Int?): Int?{
        return b?.plus(a)
    }
}