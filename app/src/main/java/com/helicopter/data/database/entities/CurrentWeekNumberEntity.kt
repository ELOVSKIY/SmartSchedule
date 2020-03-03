package com.helicopter.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val DEFAULT_ID = 0L

@Entity(tableName = "current_week_number")
data class CurrentWeekNumberEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = DEFAULT_ID,
    val weekNumber: Int
)