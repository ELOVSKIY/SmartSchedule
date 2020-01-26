package com.helicopter.data.network.remote.response.groupSchedulerResponse

import com.helicopter.data.network.models.Employee
import com.helicopter.data.network.models.StudentGroup
import com.helicopter.data.network.models.schedule.Schedule
import com.helicopter.data.network.models.schedule.ScheduleModel

data class GroupScheduleResponse(
    val employee: Employee,
    val studentGroup: StudentGroup,
    val schedules: List<Schedule>,
    val examSchedules: List<Schedule>,
    val todayDate: String,
    val todaySchedules: List<ScheduleModel>,
    val tomorrowDate: String,
    val tomorrowSchedules: List<ScheduleModel>,
    val currentWeekNumber: Int,
    val dateStart: String,
    val dateEnd: String,
    val sessionStart: String,
    val sessionEnd: String

)