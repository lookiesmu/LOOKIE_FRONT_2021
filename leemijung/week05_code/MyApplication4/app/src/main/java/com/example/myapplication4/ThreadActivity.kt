package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        //쓰레드 버튼을 누르면 실행
        val runnable:Runnable=object:Runnable{
            override fun run() {
                Log.d("thread-1", "Thread1 is made")
            }
        }
        val thread: Thread=Thread(runnable)
        button.setOnClickListener{
            thread.start()
        }

        //쓰레드 바로 실행
        Thread(object:Runnable{
            override fun run() {
                Log.d("thread-1", "Thread2 is made")
            }
        }).start()

        Thread(Runnable{
            Thread.sleep(2000)
            Log.d("thread-1", "Thread3 is made")
            runOnUiThread{ // go ui Thread
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()


    }
}