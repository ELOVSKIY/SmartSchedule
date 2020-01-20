package com.helicopter.data.network.remote.response.groupSchedulerResponse

import com.helicopter.data.network.models.Employee
import com.helicopter.data.network.models.StudentGroup
import com.helicopter.data.network.models.scheduler.Schedule
import com.helicopter.data.network.models.scheduler.ScheduleModel

data class GroupScheduleResponse(
    val employee: Employee,
    val studentGroup: StudentGroup,
    val schedules: List<Schedule>,
    val examSchedules: List<Schedule>,
    val todayDate: String,
    val todaySchedules: List<ScheduleModel>,
    val tomorrowDate: String,
    val tomorrowSchedules: List<ScheduleModel>,
    val currentWeekNumber: Int
)