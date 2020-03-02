package com.helicopter.domain.models


data class EmployeeDomainModel(
    val employeeId: Long,

    val firstName: String,
    val lastName: String,
    val middleName: String,
    val rank: String?,
    val photoLink: String?,
    val calendarId: String?, //TODO (странно вроде у всех должен быть)
    val academicDepartment: List<String>,
    val fullName: String,
    val mainSchedule: Boolean
)