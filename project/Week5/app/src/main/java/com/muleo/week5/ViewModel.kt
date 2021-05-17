package com.muleo.week5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muleo.week5.db.Event
import com.muleo.week5.db.EventDBDao
import kotlinx.coroutines.launch

class ViewModel(
    private val dao: EventDBDao
) : ViewModel() {

    val events = dao.getAllEvents()

    private suspend fun insert(event: Event) {
        dao.insert(event)
    }

    fun onSave(event: Event) {
        viewModelScope.launch {
            insert(event)
        }
    }

    private val _onDialog = MutableLiveData<Boolean>()
    val onDialog: LiveData<Boolean> get() = _onDialog

    fun onDialog() {
        _onDialog.value = onDialog.value?.let { !it } ?: true
    }
}