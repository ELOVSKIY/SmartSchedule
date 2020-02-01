package com.helicopter.data.network.models

import com.google.gson.annotations.SerializedName
import com.helicopter.data.database.entities.EmployeeEntity

data class Employee(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val rank: String?,
    val photoLink: String?,
    val calendarId: String?,
    val academicDepartment: List<String>,
    @SerializedName("id")
    val employeeId: Long,
    @SerializedName("fio")
    val fullName: String
)

fun List<Employee>.asDatabaseEntities(): List<EmployeeEntity>{
    return this.map { EmployeeEntity(
        it.employeeId,
        it.firstName,
        it.lastName,
        it.middleName,
        it.rank,
        it.photoLink,
        it.calendarId,
        it.academicDepartment,
        it.fullName
    ) }
}