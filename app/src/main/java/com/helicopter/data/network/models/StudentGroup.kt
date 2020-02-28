package com.helicopter.data.network.models

import com.google.gson.annotations.SerializedName
import com.helicopter.data.database.entities.StudentGroupEntity

data class StudentGroup(
    val calendarId: String?,
    val course: Int,
    val facultyId: Long,
    @SerializedName("id")
    val groupId: Long,
    val name: String,
    val specialityDepartmentEducationFormId: Int
)

fun List<StudentGroup>.asDatabaseEntities(): List<StudentGroupEntity>{
    return  this.map { StudentGroupEntity(
        it.groupId,
        it.name,
        it.facultyId,
        it.course,
        it.calendarId,
        it.specialityDepartmentEducationFormId
    ) }
}