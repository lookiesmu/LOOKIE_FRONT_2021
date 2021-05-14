package com.example.myapplication

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main.*

class main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val planlist: Planner = Planner()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        plus.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.dialogview, null)
            val dialogdate = dialogView.findViewById<EditText>(R.id.edit_date)
            val dialogtext = dialogView.findViewById<EditText>(R.id.edit_content)

            builder.setView(dialogView)
                .setPositiveButton("등록") { dialogInterface, i ->
                    planlist.addPlan(
                        plan(
                            dialogdate.text.toString(),
                            dialogtext.text.toString()
                        )
                    )
                }
                .setNegativeButton("취소") { dialogInterface, i ->
                }
                .show()
        }

        with(planner) {
            this.adapter = PlanAdapter(
                plan_list = planlist,
                inflater = LayoutInflater.from(this@main),
                activity = this@main
            )
            val reverseLayoutManager: LinearLayoutManager = LinearLayoutManager(this@main)
            reverseLayoutManager.reverseLayout = true
            reverseLayoutManager.stackFromEnd = true
            this.layoutManager = reverseLayoutManager
        }
    }
}