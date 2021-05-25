package com.example.myapplication6

import android.content.Context
import android.content.SharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        //Mode
        // - MODE_PRIVATE : 생성한 어플리케이션에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 어플리케이션에서 사용 가능(읽기만 가능)
        // - MODE_WORLD_WRITEABLE : 다른 어플리케이션에서 사용 가능(기록도 가능)
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preferencd에 신규로 추기한다.
        //데이터를 넣으려면 editor 사용


        load_button.setOnClickListener{

            //SharedPreference 에 값을 불러오는 빙법
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1=sharedPreference.getString("hello", "데이터없음")
            val value2=sharedPreference.getString("goodbye", "데이터없음")
            Log.d("key ,value", "value1 : "+value1)
            Log.d("key ,value", "value2 : "+value2)

        }

        save_button.setOnClickListener{
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            //SharedPreference 에 저장하는 방법
            val editor: SharedPreferences.Editor=sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }

        delete_button.setOnClickListener{
            // 부분 지우기
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.remove("hello") // hello 키값 삭제
            editor.commit()

        }

        delete_all_button.setOnClickListener{
            // 전체 지우기
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.clear()
            editor.commit()


        }





        // 만약 데이터베이스 저장된 것을 지우고 싶다면 어플리케이션 설정에서 clear
    }
}

