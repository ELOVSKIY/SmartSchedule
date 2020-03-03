package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.CurrentWeekNumberEntity

@Dao
interface CurrentWeekNumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateCurrentWeekNumber(weekNumber: CurrentWeekNumberEntity)

    @Query("SELECT weekNumber FROM current_week_number")
    fun fetchCurrentWeekNumberLive(): LiveData<Int>

    @Query("SELECT weekNumber FROM current_week_number")
    suspend fun fetchCurrentWeekNumber(): Int?
}