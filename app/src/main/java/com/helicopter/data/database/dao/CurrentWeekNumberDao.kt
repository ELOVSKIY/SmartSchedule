package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.CurrentWeekNumberEntity

interface CurrentWeekNumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateCurrentWeekNumber(weekNumber: CurrentWeekNumberEntity)

    @Query("SELECT weekNumber FROM current_week_number")
    fun fetchCurrentWeekNumber(): LiveData<Int>
}