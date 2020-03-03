package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.ScheduleModelEntity

interface ScheduleRepository {

    suspend fun updateSchedule()

}