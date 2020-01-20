package com.helicopter.data.network.models.scheduler

import com.helicopter.data.network.models.Employee

data class ScheduleModel(
    val auditory: List<String>,
    val employee: List<Employee>,
    val endLessonTime: String,
    val lessonTime: String,
    val lessonType: String,
    val note: String,
    val numSubgroup: Int,
    val startLessonTime: String,
    val studentGroup: List<String>,
    val subject: String,
    val weekNumber: List<Int>,
    val zaoch: Boolean
)