package com.example.week5_kyj

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanAdapter (
    val planList: ArrayList<Plan>, val inflater: LayoutInflater
): RecyclerView.Adapter<PlanAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val planDate: TextView = itemView.findViewById(R.id.date_plan)
        val planText: TextView = itemView.findViewById(R.id.text_plan)

        fun bind (plan: Plan) {
            planDate?.text = plan.plandate
            planText?.text = plan.plantext
        }
//        init {
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.plan_view, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return planList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.planDate.setText(planList.get(position).plandate)
        holder.planText.setText(planList.get(position).plantext)

    }

}