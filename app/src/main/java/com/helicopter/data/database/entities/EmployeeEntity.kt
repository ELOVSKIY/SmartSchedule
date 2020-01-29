package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.helicopter.data.database.entities.convertors.ListConverter
//CORRECT ENTITY
@Entity(tableName = "employee")
@TypeConverters(ListConverter::class)
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "employee_id")
    val employeeId: Int,

    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "middle_name")
    val middleName: String,
    val rank: String,
    @ColumnInfo(name = "photo_link")
    val photoLink: String,
    @ColumnInfo(name = "calendar_id")
    val calendarId: String,
    @ColumnInfo(name = "academic_department")
    val academicDepartment: List<String>,

    @ColumnInfo(name = "dull_name")
    val fullName: String
)