package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.helicopter.data.database.entities.ScheduleEntity

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule WHERE group_id = :groupId")
    suspend fun getScheduleListByGroupId(groupId: Int): LiveData<List<ScheduleEntity>>

    @Query("SELECT * FROM schedule WHERE group_name = :groupName")
    suspend fun getScheduleListByGroupName(groupName: String): LiveData<List<ScheduleEntity>>

    @Insert
    fun insertScheduleList(scheduleList: List<ScheduleEntity>)
}