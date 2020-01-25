package com.helicopter.data.network.remote.response.employeeScheduleResponse

import com.helicopter.data.network.models.Employee
import com.helicopter.data.network.models.StudentGroup
import com.helicopter.data.network.models.scheduler.Schedule
import com.helicopter.data.network.models.scheduler.ScheduleModel

class EmployeeScheduleResponse(
    employee: Employee,
    studentGroup: StudentGroup?,
    schedules: List<Schedule>,
    todayDate: String,
    todaySchedules: List<ScheduleModel>,
    tomorrowData: String,
    tomorrowSchedules: List<ScheduleModel>,
    currentWeekNumber: Int
    )