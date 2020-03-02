package com.helicopter.domain.models


data class StudentGroupDomainModel (
    val groupId: Long,
    val name: String,
//    val facultyId: Long,
    val course: Int,
    val calendarId: String?,
    val mainSchedule: Boolean
//    val specialityDepartmentEducationFormId: Int
)