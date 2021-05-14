package com.example.myapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanAdapter(
    val plan_list: Planner,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PlanAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val planDate: TextView
        val planContent: TextView

        init {
            planDate = itemView.findViewById(R.id.plan_date)
            planContent = itemView.findViewById(R.id.plan_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanAdapter.ViewHolder {
        val view = inflater.inflate(R.layout.planview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plan_list.planList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.planDate.setText(plan_list.planList.get(position).date)
        holder.planContent.setText(plan_list.planList.get(position).content)
    }
}