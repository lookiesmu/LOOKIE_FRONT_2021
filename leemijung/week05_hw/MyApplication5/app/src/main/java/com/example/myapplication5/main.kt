package com.example.myapplication5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.dialogview.view.*
import kotlinx.android.synthetic.main.main.*
//import kotlinx.android.synthetic.main.planview.*

class main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val planList:Planner=Planner()  //리스트 가져오기

        add_button.setOnClickListener{
            val dialogview=LayoutInflater.from(this).inflate(R.layout.dialogview, null)

            val builder= AlertDialog.Builder(this).setView(dialogview) //dialog
            val dialogview_data=dialogview.findViewById<EditText>(R.id.data_write)
            val dialogview_contents=dialogview.findViewById<EditText>(R.id.contents_write)

//            val addPlanDialog=builder.show()

            builder.setView(dialogview)
                .setPositiveButton("add") { dialogInterface, i ->

                    val text = dialogview_data.text.toString()
                    val text2 = dialogview_contents.text.toString()
                    planList.add(Plan(text, text2))
                }
                .setNegativeButton("cancel") { dialogInterface, i ->
                }
                .show()
        }


        val aadapter = planAdapter(planList, LayoutInflater.from(this@main))
        plan_location.adapter = aadapter
        val manager = LinearLayoutManager(this)
        manager.reverseLayout = true
        manager.stackFromEnd = true
        plan_location.layoutManager = manager



    }
}

//            dialogview.ADD.setOnClickListener {
//                planList.add(Plan(
//                    dialogview_data.text.toString(), dialogview_contents.text.toString()
//                ))  // 이부분 에러!!!
//                (plan_location.adapter as planAdapter).notifyDataSetChanged()
//                addPlanDialog.dismiss()
//            }
//
//            dialogview.CANCEL.setOnClickListener {
//                addPlanDialog.dismiss()
//            }
//        }
//        plan_location.adapter=planAdapter(planList, LayoutInflater.from(this), this)
//        plan_location.layoutManager= LinearLayoutManager(this)
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//}