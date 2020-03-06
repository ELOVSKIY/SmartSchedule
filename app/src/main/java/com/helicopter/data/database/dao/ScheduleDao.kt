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
    fun fetchScheduleListByGroupId(groupId: Long): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE group_name = :groupName")
    fun fetchScheduleListByGroupName(groupName: String): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE employee_id = :employeeId")
    fun fetchScheduleListByEmployeeId(employeeId: Long): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE group_id = :groupId AND week_number LIKE :weekNumber AND week_day = :day AND (num_subgroup =:subgroupNumber OR num_subgroup='0') ORDER BY start_lesson_time")
    suspend fun fetchScheduleListByGroupIdAndWeek(
        groupId: Long,
        subgroupNumber: String,
        weekNumber: String,
        day: String
    ): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE group_name = :groupName AND week_number = :weekNumber AND week_day = :day ORDER BY start_lesson_time")
    suspend fun fetchScheduleByGroupNameAndWeek(
        groupName: String,
        weekNumber: Int,
        day: String
    ): List<ScheduleModelEntity>

    @Query("SELECT * FROM schedule_model WHERE employee_id = :employeeId AND week_number LIKE :weekNumber AND week_day = :day ORDER BY start_lesson_time")
    suspend fun fetchScheduleByEmployeeIdAndWeek(
        employeeId: Long,
        weekNumber: String,
        day: String
    ): List<ScheduleModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScheduleList(scheduleList: List<ScheduleModelEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(schedule: ScheduleModelEntity)
}