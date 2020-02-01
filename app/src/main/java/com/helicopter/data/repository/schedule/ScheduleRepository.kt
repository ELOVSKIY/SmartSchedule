package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.ScheduleModelEntity

interface ScheduleRepository {
    suspend fun fetchScheduleByGroupId(groupId: Long): LiveData<List<ScheduleModelEntity>>

    suspend fun fetchScheduleByGroupName(groupName: String): LiveData<List<ScheduleModelEntity>>

    suspend fun fetchScheduleByEmployeeId(employeeId: Long): LiveData<List<ScheduleModelEntity>>
}