package com.example.myapplication5

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class planAdapter(
    val plan_list:Planner,
    val inflater: LayoutInflater,
    //val activity: Activity
): RecyclerView.Adapter<planAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val dataName: TextView
        val contentsName: TextView
        init{
            dataName=itemView.findViewById(R.id.date)
            contentsName=itemView.findViewById(R.id.contents)
        }
    }



    //뷰 만들기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.planview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataName.setText(plan_list.planlist.get(position).date)
        holder.contentsName.setText(plan_list.planlist.get(position).contents)

    }

    override fun getItemCount(): Int {
        return plan_list.planlist.size
    }

}



