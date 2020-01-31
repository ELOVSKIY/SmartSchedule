package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.helicopter.data.database.entities.ScheduleModelEntity

@Dao
interface ScheduleModelDao {

    @Query("SELECT * FROM schedule_model WHERE group_id = :groupId")
    fun fetchScheduleListByGroupId(groupId: Long): LiveData<List<ScheduleModelEntity>>

    @Query("SELECT * FROM schedule_model WHERE group_name = :groupName")
    suspend fun fetchScheduleListByGroupName(groupName: String): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE employee_id = :employeeId")
    fun fetchScheduleListByEmployeeId(employeeId: Long): LiveData<List<ScheduleModelEntity>>

    @Insert
    suspend fun insertScheduleList(scheduleList: List<ScheduleModelEntity>)

    @Insert
    suspend fun insertSchedule(schedule: ScheduleModelEntity)
}