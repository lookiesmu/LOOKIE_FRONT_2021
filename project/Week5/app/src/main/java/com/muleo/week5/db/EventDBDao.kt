package com.muleo.week5.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDBDao {

    @Insert
    suspend fun insert(event: Event)

    @Query("SELECT * FROM event_table ORDER BY eventId DESC")
    fun getAllEvents(): LiveData<List<Event>>

}