package com.helicopter.data.network.models.schedule

import com.google.gson.annotations.SerializedName
import com.helicopter.data.network.models.Auditory
import com.helicopter.data.network.models.Employee
import com.helicopter.data.network.models.StudentGroup

data class ScheduleModel(
    val auditory: Auditory,
    val employee: List<Employee>,
    val endLessonTime: String,
    val lessonTime: String,
    val lessonType: String,
    val note: String,
    val numSubgroup: Int,
    val startLessonTime: String,
    val studentGroup: StudentGroup,
    val subject: String,
    val weekNumber: List<Int>,
    @SerializedName("zaoch")
    val correspondence: Boolean
)