package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_linstener.*
import org.w3c.dom.Text

class Linstener : AppCompatActivity() {
    var number=10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linstener)

        //뷰를 activity로 가져오는 방법 2가지

        // 1> 직접 찾아서 가져온다
        //val tv: TextView=findViewById(R.id.hello)

        // 2> xml을 import 해서 가져온다
            // 1. 람다 방식 (=익명함수를 간단하게 사용하기 위함 방법)
        hello.setOnClickListener{
            Log.d("click", "Click!")
        }

            // 2. 익명함수 방식
        hello.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v:View?){
                Log.d("click", "Click!")
            }
        })

            // 3. 이름이 필요한 경우, 이름으로 저장. (ex, click할때 동작하게 하는 경우)
        val click=object:View.OnClickListener{
            override fun onClick(v:View?){
                Log.d("click", "Click!")
                hello.setText("안녕하세요") //click하면 text 변경
                image.setImageResource(R.drawable.sun) //click하면 image 변경
                number+=10
                Log.d("number", ""+number)
            }
        }
        hello.setOnClickListener(click)

        //뷰를 조작하는 함수들
        // 1> setText
        // 2> setImageResource


    }
}