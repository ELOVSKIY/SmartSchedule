package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_group")
data class StudentGroupEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "group_id")
    val groupId: Int,

    @ColumnInfo(name = "calendar_id")
    val calendarId: String,
    val course: Int,
    @ColumnInfo(name = "faculty_id")
    val facultyId: Int,
    @ColumnInfo(name = "group_name")
    val name: String,
    @ColumnInfo(name = "speciality_department_education_form_id")
    val specialityDepartmentEducationFormId: Int
)