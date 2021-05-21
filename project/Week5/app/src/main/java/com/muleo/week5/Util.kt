package com.muleo.week5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muleo.week5.databinding.EventViewBinding
import com.muleo.week5.db.Event
import java.text.SimpleDateFormat

class EventViewHolder(val binding: EventViewBinding) : RecyclerView.ViewHolder(binding.root)


class EventAdapter() : RecyclerView.Adapter<EventViewHolder>() {

    var data = listOf<Event>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EventViewBinding.inflate(layoutInflater, parent, false)
        return EventViewHolder(binding)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = data[position]
        holder.binding.apply {
            // 일정 이름
            tvEventName.text = event.name;
            // 일정 헤더
            tvDay.text = SimpleDateFormat(Fragment.DATE_FORMAT_DAY).format(event.from)
            tvDayOfWeek.text = SimpleDateFormat(Fragment.DATE_FORMAT_DAY_OF_WEEK).format(event.from)
            // 일정 기간
            tvDate.text = "${SimpleDateFormat(Fragment.DATE_FORMAT).format(event.from)} - ${
                SimpleDateFormat(Fragment.DATE_FORMAT).format(event.to)
            }"
        }
    }

    override fun getItemCount() = data.size
}