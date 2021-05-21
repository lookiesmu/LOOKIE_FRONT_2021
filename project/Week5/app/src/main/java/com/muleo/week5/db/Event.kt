package com.muleo.week5.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val eventId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "from")
    val from: Long,

    @ColumnInfo(name = "to")
    val to: Long,
)
