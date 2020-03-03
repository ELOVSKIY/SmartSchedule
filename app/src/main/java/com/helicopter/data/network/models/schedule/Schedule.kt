package com.helicopter.data.network.models.schedule

data class Schedule(
    val weekDay: String,
    val schedule: List<ScheduleModel>
)