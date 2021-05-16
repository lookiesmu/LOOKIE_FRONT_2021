package com.example.week5_kyj

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.week5_kyj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var planList = ArrayList<Plan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pAdapter = PlanAdapter(planList, LayoutInflater.from(this@MainActivity))
        binding.planrecyclerView.adapter = pAdapter

        binding.addplan.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val dialogView = layoutInflater.inflate(R.layout.dialog_view, null)

            val dialogDate = dialogView.findViewById<EditText>(R.id.date_edit)
            val dialogText = dialogView.findViewById<EditText>(R.id.text_edit)

            builder.setView(dialogView)
                .setPositiveButton("ADD") { dialog: DialogInterface?, which: Int ->
//                    planList.add(dialogDate.text.toString(),dialogText.text.toString())
//                    planList.planDate.text = dialogDate.text.toString()
//                    findViewById<TextView>(R.id.text_plan).text = dialogText.text.toString() //모르겠다ㅠㅠ...
                }
                .setNegativeButton("CANCEL"){dialog: DialogInterface?, which: Int ->

                }
                .show()

        }

    }
}