package com.muleo.wek2

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muleo.wek2.adapter.GifItem
import com.muleo.wek2.giphy.Giphy

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: Giphy?,
) {

    val adapter = recyclerView.adapter as OverviewActivity.GifItemAdapter
    data?.let {
        Log.d("BindingAdapter", "네트워크 정상 -> GifItem 으로 변환 성공 -> adapter.setGifItems()")
        adapter.setGifItems()

    }
}