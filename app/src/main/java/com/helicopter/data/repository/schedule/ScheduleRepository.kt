package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.ScheduleModelEntity

interface ScheduleRepository {
    val schedule: LiveData<List<ScheduleModelEntity>>

    suspend fun fetchScheduleByGroupId(groupId: Long)

    suspend fun fetchScheduleByGroupName(groupName: String)

    suspend fun fetchScheduleByEmployeeId(employeeId: Long)
}