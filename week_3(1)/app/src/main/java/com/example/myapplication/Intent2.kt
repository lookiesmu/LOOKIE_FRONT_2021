package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 0)
            val number2 : Int = intent.getIntExtra("number2", 0)

            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            setResult(Activity.RESULT_OK, resultIntent)  //RESULT_OK=setResult(1) -> 컨트롤+커맨드+오케이 눌러서 확인
            finish() // ->Activity 종료

            //스택(Stack)
            //Intent2  -> 종료
            //Intent1           intent1
        }
    }
}