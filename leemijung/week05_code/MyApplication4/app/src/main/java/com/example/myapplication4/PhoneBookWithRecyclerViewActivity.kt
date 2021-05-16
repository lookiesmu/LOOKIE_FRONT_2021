package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        val phoneBook=creatFakePhoneBook(faskNumber = 30)
        val phoneBookRecyclerAdapter=PhoneBookRecyclerAdapter(phoneBook, LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity))
        phonebook_recyclerview.adapter=phoneBookRecyclerAdapter
        phonebook_recyclerview.layoutManager=LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

    }
    fun creatFakePhoneBook(faskNumber:Int=10, phoneBook:PhoneBook=PhoneBook()):PhoneBook{
        for(i in 0 until faskNumber){

            phoneBook.addPerson(
                Person(name=""+i+"번째 사람", number=""+i+"번째 사람의 전화 번호")
            )
        }
        return phoneBook
    }


}


class PhoneBookRecyclerAdapter(
    val phonebookList:PhoneBook,
    val inflater: LayoutInflater
): RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personName:TextView
        init{
            personName=itemView.findViewById(R.id.person_name)
        }
    }

    //뷰 만들기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }
}