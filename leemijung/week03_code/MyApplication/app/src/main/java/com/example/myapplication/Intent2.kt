package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        result.setOnClickListener{

            // intent 값 불러오기 (값이 없으면 0 디폴트)
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result=number1+number2
            // intent1로 돌려주기
            //setResult : 결과를 설정하는 것
            val resultIntent = Intent() // intent 생성
            resultIntent.putExtra("result", result) // 결과값 넣기
            // setResult 함수에 결과값을 할당 : intent1 에 전송
            setResult(RESULT_OK, resultIntent)  // RESULT_OK = -1  // 사실 숫자를 적는 것인데 문자가 읽기 좋기 때문에 문자로 넣는다

            finish() // activity 종료 함수 // intent2가 사라짐.
            // activity 는 "스택"의 개념이다.
            // intent1이 생기고 버튼을 누르면 intent1에서 intent2를 호출한다.
            // finish() 를 통해 intent2를 종료
            // 원래 존재했던 intent1이 나온다.

        }
    }
}