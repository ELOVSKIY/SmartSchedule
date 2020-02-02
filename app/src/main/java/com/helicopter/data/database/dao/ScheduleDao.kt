package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.ScheduleModelEntity

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule_model WHERE group_id = :groupId")
    fun fetchScheduleListByGroupId(groupId: Long): LiveData<List<ScheduleModelEntity>>

    @Query("SELECT * FROM schedule_model WHERE group_name = :groupName")
    suspend fun fetchScheduleListByGroupName(groupName: String): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE employee_id = :employeeId")
    suspend fun fetchScheduleListByEmployeeId(employeeId: Long): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE group_id = :groupId AND week_number = :weekNumb AND week_day = :weekDay")
    fun fetchScheduleListByGroupIdAndWeek(
        groupId: Long,
        weekNumb: Int,
        weekDay: String
    ): LiveData<List<ScheduleModelEntity>>

    @Query("SELECT * FROM schedule_model WHERE group_name = :groupName AND week_number = :weekNumb AND week_day = :weekDay")
    suspend fun fetchScheduleListByGroupNameAndWeek(
        groupName: String,
        weekNumb: Int,
        weekDay: String
    ): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE employee_id = :employeeId AND week_number = :weekNumb AND week_day = :weekDay")
    fun fetchScheduleListByEmployeeIdAndWeek(
        employeeId: Long,
        weekNumb: Int,
        weekDay: String
    ): LiveData<List<ScheduleModelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertScheduleList(scheduleList: List<ScheduleModelEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchedule(schedule: ScheduleModelEntity)
}