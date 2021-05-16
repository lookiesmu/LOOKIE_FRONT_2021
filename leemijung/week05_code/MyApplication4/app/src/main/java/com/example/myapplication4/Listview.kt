package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listview.*

class Listview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val carlist=ArrayList<Car>()
        for( i in 0 until 10){
            carlist.add(Car(""+i+"번째 자동차", ""+i+"순위 엔진"))
        }


        val adapter=ListViewAdapter(carlist, LayoutInflater.from(this@Listview))
        listView.adapter=adapter

        // 리스트에 리스너 달기  setOnClickListener가 아닌,
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as Car).name
            val carEngine = (adapter.getItem(position) as Car).engine

            // 토스트 말풍선 띄우기 (인자: 현재 창, 띄울 내용, 띄울 시간)
            Toast.makeText(this@Listview, carName+""+carEngine, Toast.LENGTH_LONG).show()

        }
    }
}

class ListViewAdapter(
    val carForList:ArrayList<Car>,
    val layoutInflater: LayoutInflater
    ):BaseAdapter(){


    // 그리고자 하는 리스트가 총 몇개 있는지 확인
    override fun getCount(): Int {
        return carForList.size
    }

    // 그리고자 하는 리스트의 하나를 알려줌(해당 index의 정보를 알려줌)
    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    // 해당 포지션에 위치해 있는 각 리스트에 아이디 부여
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 뷰를 그리는 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //val view=layoutInflater.inflate(R.layout.item_view, null)
        //var carNameTextView=view.findViewById<TextView>(R.id.car_name)
        //var carEngineTextView=view.findViewById<TextView>(R.id.car_engine)
        //// findViewById : 리소스를 많이 사용하는 함수. -> 개선 여지

        //carNameTextView.setText(carForList.get(position).name)
        //carEngineTextView.setText(carForList.get(position).engine)

        //return view   // 이 부분이 addview와 다름.

        val view:View
        val holder:ViewHolder
        if(convertView==null){ // 처음
            view=layoutInflater.inflate(R.layout.item_view, null)
            holder= ViewHolder()
            // holder에 집어넣는다
            holder.carName=view.findViewById(R.id.car_name)
            holder.carEngine=view.findViewById(R.id.car_engine)

            view.tag=holder //재사용하기 위해 tag를 달아놓는다.
        }
        else{ // 재사용할 것이 있다면, (처음이 아니라면)
            holder=convertView.tag as ViewHolder
            view=convertView
        }

        // ?: null 이 아닌 경우에 setText를 하겠다다
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)


        return view


    }
}

class ViewHolder{
    var carName:TextView?=null
    var carEngine:TextView?=null


}