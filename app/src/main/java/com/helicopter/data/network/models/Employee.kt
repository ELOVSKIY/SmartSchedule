package com.helicopter.data.network.models

import com.google.gson.annotations.SerializedName

data class Employee(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val rank: String,
    val photoLink: String,
    val calendarId: String,
    val academicDepartment: List<String>,
    @SerializedName("id")
    val employeeId: Int,
    @SerializedName("fio")
    val fullName: String
)