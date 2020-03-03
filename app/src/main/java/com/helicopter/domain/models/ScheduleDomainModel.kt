package com.helicopter.domain.models

import com.helicopter.data.network.models.Employee

data class ScheduleDomainModel (
    val groupId: Long,
    val employeeId: Long,
    val groupName: String,
    val employee: Employee?,

    val subject: String,


    val weekDay: String,
    val weekNumber: List<Int>,
    val numSubgroup: Int,
    val studentGroup: List<String>,


    val auditory: List<String>,

    val startLessonTime: String,
    val endLessonTime: String,
    val lessonTime: String,
    val lessonType: String,

    val note: String,

    val correspondence: Boolean
)