package com.example.myapplication6

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        //BackgroundAsyncTask 실행, 정지
        var task:BackgroundAsyncTask?=null
        start.setOnClickListener{
            task = BackgroundAsyncTask(progressbar, ment) // 버튼을 클릭할때마다 만들어지도록 구현
            task?.execute() //실행
        }
        stop.setOnClickListener{
            task?.cancel(true) //정지
        }
    }
}


class BackgroundAsyncTask(
    val progressbar:ProgressBar,
    val progressText: TextView
): AsyncTask<Int, Int, Int>(){
    // 인자 세 가지의 설명.
    // 1. params -> doInBackground 에서 사용할 타입
    // 2. progress -> onProgressUpdata 에서 사용할 타입
    // 3. result -> onPostExecute 에서 사용할 타입

    var percent:Int=0 // 퍼센트가 변해야 하므로 var로 선언

    override fun onPreExecute() {
        percent=0
        progressbar.setProgress(percent)  // 실행하기 바로 직전 0 셋팅
    }

    // 1.
    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled()==false){ // 불린값 리턴됨
            percent++
            if(percent>100){
                break
            } else{
                publishProgress(percent)
            }
            try{
                Thread.sleep(100) //1000=1s
                // 과정을 보여주기 위해 쓰레드를 잠재운다
            }catch (e:Exception) {
                e.printStackTrace() //왜 발생했는지 알려줌
            }
        }
        return percent
    }

    // 2.
    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0) //null 인 경우에는 0
        progressText.setText("퍼센트 : "+values[0])
        super.onProgressUpdate(*values)
    }
    // 3.
    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }


    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}
