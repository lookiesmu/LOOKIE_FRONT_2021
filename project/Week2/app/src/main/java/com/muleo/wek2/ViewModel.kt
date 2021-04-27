package com.muleo.wek2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muleo.wek2.adapter.GifItem
import com.muleo.wek2.giphy.Giphy
import com.muleo.wek2.network.Ktor
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    lateinit var query: String
    lateinit var gitList: List<GifItem>

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    private val _giphy = MutableLiveData<Giphy>()

    val giphy: LiveData<Giphy>
        get() = _giphy

//    init {
//        getGiphyBy()
//    }

    fun getGiphyBy(query: String = "manga") {
        Log.d("ViewModel", "네트워크 시작")
        viewModelScope.launch {
            try {
                val result = Ktor.ktor_url(query)
                _response.value = "Success: ${result.data.size} GIF retrieved"
                if (result.data.isNotEmpty()) {
                    _giphy.value = result
                    Log.d("ViewModel", "네트워크 정상받음")
                }
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("ViewModel", "네트워크 실패 : ${_response.value}")
            }
        }
    }

    fun getGifItem(): List<GifItem> {
        if (!::gitList.isInitialized || gitList.isEmpty()) {
            gitList = _giphy.value?.data?.map { GifItem(it.id, it.title) } ?: emptyList()
            Log.d("ViewModel", "getGigItem() 처음 isEmpty()? : ${gitList.isEmpty()}")
            return gitList
        } else {
            Log.d("ViewModel", "getGigItem() 이후")
            return gitList
        }
    }
}