package com.example.cws_week5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val planList: planlist = planlist()


        plan_add_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.dialog_view, null)
            val dialogdate = dialogView.findViewById<EditText>(R.id.edit_date)
            val dialogtext = dialogView.findViewById<EditText>(R.id.edit_content)

            builder.setView(dialogView)
                .setPositiveButton("add") { dialogInterface, i ->
                    planList.addPlan(
                        plan(
                            dialogdate.text.toString(), dialogtext.text.toString()
                        )
                    )
                }
                .setNegativeButton("cancel") { dialogInterface, i ->
                }
                .show()
        }


        planner_recyclerview.adapter =
            planAdapter(planList, LayoutInflater.from(this), activity = this)
        val manager = LinearLayoutManager(this)
        manager.reverseLayout = true
        manager.stackFromEnd = true
        planner_recyclerview.layoutManager = manager

    }
}

class planAdapter(
    val plan_list: planlist,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<planAdapter.ViewHolder>() {

    inner class ViewHolder(plan_view: View) : RecyclerView.ViewHolder(plan_view) {
        val planDate: TextView
        val planContent: TextView

        init {
            planDate = plan_view.findViewById(R.id.plan_date)
            planContent = plan_view.findViewById(R.id.plan_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.plan_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plan_list.planlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.planDate.setText(plan_list.planlist.get(position).date)
        holder.planContent.setText(plan_list.planlist.get(position).content)
    }
}