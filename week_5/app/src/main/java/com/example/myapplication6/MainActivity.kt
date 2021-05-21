package com.example.myapplication6

import android.content.DialogInterface
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
import kotlinx.android.synthetic.main.activity_recycler_adapter.*
import kotlinx.android.synthetic.main.item_recycler.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val planList=ArrayList<Plan>()

        button.setOnClickListener {
            val builder = android.app.AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.item_recycler, null)
            val dialogDate = dialogView.findViewById<EditText>(R.id.dialog_date)
            val dialogContent = dialogView.findViewById<EditText>(R.id.dialog_content)

            builder.setView(dialogView)
                .setPositiveButton("등록") { dialogInterface, i ->

                    val text = dialogDate.text.toString()
                    val text2 = dialogContent.text.toString()
                    planList.add(Plan(text, text2))
                }
                    .setNegativeButton("취소") { dialogInterface, i ->
                    }
                .show()
        }
        val customAdapter = RecyclerAdapter(planList, LayoutInflater.from(this))
        rView.adapter = customAdapter
        val manager = LinearLayoutManager(this)
        manager.reverseLayout = true
        manager.stackFromEnd = true
        rView.layoutManager = manager

    }
}



class Plan(val date: String, val content: String) {
}
class RecyclerAdapter (
    val planList: ArrayList<Plan>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = inflater.inflate(R.layout.activity_recycler_adapter, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return planList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.date.setText(planList.get(position).date)
        holder.content.setText(planList.get(position).content)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val date: TextView
        val content: TextView

        init {
            date = itemView.findViewById(R.id.day)
            content = itemView.findViewById(R.id.cont)
        }
    }

}