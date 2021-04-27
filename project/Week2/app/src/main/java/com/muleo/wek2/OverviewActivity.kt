package com.muleo.wek2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.util.ViewPreloadSizeProvider
import com.muleo.wek2.adapter.GifItem
import com.muleo.wek2.databinding.ActivityOverviewBinding
import java.util.*

class OverviewActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView
    private lateinit var adapter: GifItemAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var preloadSizeProvider: ViewPreloadSizeProvider<GifItem>
    private lateinit var preloadModelProvider: MyPreloadModelProvider

    private lateinit var fullRequest: RequestManager


    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this).get(ViewModel::class.java)
    }

    fun updateGifItems(gisItems: List<GifItem>) {
        //TODO
        // 뷰모델의 것을 바꾸어 주고 adapter가 null 이 아니면 set함수를 이용해 바꾸어준다.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityOverviewBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_overview
        )
        binding.also {
            it.lifecycleOwner = this@OverviewActivity
            it.viewModel = this@OverviewActivity.viewModel
        }

        list = binding.overviewRecyclerView
        layoutManager = LinearLayoutManager(this@OverviewActivity)
        list.layoutManager = this@OverviewActivity.layoutManager
        this@OverviewActivity.adapter =
            GifItemAdapter(viewModel.getGifItem())
        Log.d("OverviewActivity", "onCreate() -> 어뎁터 설정중 생성자 argument :  ${viewModel.getGifItem()}")
        list.adapter = this@OverviewActivity.adapter

        preloadSizeProvider = ViewPreloadSizeProvider() //TODO 나중에 view 셋 해줌
        preloadModelProvider = MyPreloadModelProvider()
        val preloader: RecyclerViewPreloader<GifItem> = RecyclerViewPreloader(
            Glide.with(this@OverviewActivity),
            preloadModelProvider,
            preloadSizeProvider,
            PRELOAD_AHEAD_ITEMS
        )
        list.addOnScrollListener(preloader)

        fullRequest = Glide.with(this@OverviewActivity) // 취소를 위한

        list.setRecyclerListener { holder ->
            val vh = holder as ItemViewHolder
            fullRequest.clear(vh.imgView)
        }

        viewModel.getGiphyBy(intent.getStringExtra("query")?.apply {
            viewModel.query = this
            Log.d("OverviewActivity", "인텐트 받음 : query = ${intent.getStringExtra("query")}")
        } ?: viewModel.query)
    }

    companion object {
        private const val PRELOAD_AHEAD_ITEMS = 5
    }

    private inner class MyPreloadModelProvider : ListPreloader.PreloadModelProvider<GifItem> {
        override fun getPreloadItems(position: Int): MutableList<GifItem> {
            Log.d("OverviewActivity", "gitItem 해당 position=${position} url 얻는중!")
            return mutableListOf(viewModel.getGifItem()[position])
        }

        override fun getPreloadRequestBuilder(item: GifItem): RequestBuilder<*>? {
            Log.d("OverviewActivity", "얻은 url 로 Preload pull request!!! ")
            return Glide
                .with(this@OverviewActivity)
                .load(item.url)
        }
    }

    inner class GifItemAdapter(
        private var gifItems: List<GifItem>
    ) : RecyclerView.Adapter<ItemViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(this@OverviewActivity)

        fun setGifItems(gifitems: List<GifItem> = viewModel.getGifItem()) {
            this@GifItemAdapter.gifItems = gifitems
            Log.d("GifItemAdapter", "setGifItems() -> notifyDataSetChanged()")
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = inflater.inflate(R.layout.list_gif_item, parent, false)
            val vh = ItemViewHolder(view)
            preloadSizeProvider.setView(vh.imgView) // 이미지 사이즈 설정
            return vh
        }

        override fun getItemCount(): Int {
            return gifItems.size
        }

        override fun onBindViewHolder(
            holder: ItemViewHolder,
            position: Int
        ) {
            val gifItem = gifItems[position]
            fullRequest.load(gifItem.url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_baseline_broken_image)
                )
                .into(holder.imgView)
            Log.d("GifItemAdapter", "onBindViewHolder() ->  full request!! , position=${position}")
            holder.imgView.setOnClickListener { view ->
                //TODO
            }

            holder.textView.text = gifItem.title
        }
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.git_item_image)
        val textView: TextView = view.findViewById(R.id.gif_item_title)
    }

}

