package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text
import java.io.LineNumberReader

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        // item List 준비 끝.
        val carlist=ArrayList<Car>()
        for( i in 0 until 10){
            carlist.add(Car(""+i+"번째 자동차", ""+i+"순위 엔진"))
        }

        // 생성된 10개를 addview를 이용해 더한다.
        val container=  findViewById<LinearLayout>(R.id.addview_container) // activity에 종속되어 있는 xml에서 찾기
        val inflater = this@AddViewActivity.layoutInflater  //layoutInflater.from(this@AddViewActivity)
        for (i in 0 until carlist.size){
            val itemView=inflater.inflate(R.layout.item_view, null) // 아이템 하나를 넣을 뷰 가져오기
            val CarNameView = itemView.findViewById<TextView>(R.id.car_name) // 아이템뷰에서 찾기
            val CarEngineView = itemView.findViewById<TextView>(R.id.car_engine)

            CarNameView.setText(carlist.get(i).name)
            CarEngineView.setText(carlist.get(i).engine)

            container.addView(itemView) // 아이템뷰 더하기
        }
    }

}
class Car(val name:String, val engine:String){

}