package com.helicopter.domain.models

import com.helicopter.data.network.models.Employee

data class ScheduleDomainModel (
    val weekDay: String,
    val groupId: Long,
    val employeeId: Long,
    val groupName: String,
    val auditory: List<String>,
    val employee: Employee?,
    val endLessonTime: String,
    val lessonTime: String,
    val lessonType: String,
    val note: String,
    val numSubgroup: Int,
    val startLessonTime: String,
    val studentGroup: List<String>,
    val subject: String,
    val weekNumber: List<Int>,
    val correspondence: Boolean,
    val isGroupSchedule: Boolean
)