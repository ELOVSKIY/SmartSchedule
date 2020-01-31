package com.helicopter.data.network.models

import com.google.gson.annotations.SerializedName

data class StudentGroup(
    val calendarId: String,
    val course: Int,
    val facultyId: Int,
    @SerializedName("id")
    val groupId: Long,
    val name: String,
    val specialityDepartmentEducationFormId: Int
)