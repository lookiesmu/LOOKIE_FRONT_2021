package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent1.*
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)


        change_activity.setOnClickListener{
//            val intent = Intent(this@Intent1, Intent2::class.java)
//            // Key, Value 방식-> Key와 Value를 쌍으로 만들어 저장한다 = Dictionary
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            // intent 연결
//           startActivity(intent)



            // 더 좋은 표현 방법
            // 위의 동작과 같지만 더 깔끔하게 표현 가능.
            // apply -> this라는 것을 사용할 수 있게 함. (this = intent2)
            // this 를 통해 빨리 구분할 수 있음, 괄호 안의 intent가 전부라는 것을 뜻함.

//            val intent2=Intent(this@Intent1, Intent2::class.java)
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2",2)
//            } // putExtra : intent에 정보를 실어서 보냄.
//
//            // startActivity(intent2) : 전달만하는 요청 (즉, 결과값을 받을 수 없는 요청임)
//            startActivityForResult(intent2, 200) // intent2에게 요청하는 것이 이것만이 아님
//                                                            // 따라서 구분이 필요하기 때문에 숫자를 넣어 자신임을 알림 - 200


            // 암시적 인텐트
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }

    }

    // 전송된 결과값 받기  // oncreate 밖에서 작동해야 함
    // 방법: 마우스 오른쪽 버튼 -> generate -> override -> "onactivityResult" 검색
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==200){ // 내가 보낸 요청의 답이 맞는지 확인
            Log.d("number", ""+requestCode)
            Log.d("number", ""+resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", ""+result)
        }


    }
}