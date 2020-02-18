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
    val employeeId: Long,

    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "middle_name")
    val middleName: String,
    val rank: String?,
    @ColumnInfo(name = "photo_link")
    val photoLink: String?,
    @ColumnInfo(name = "calendar_id")
    val calendarId: String?, //TODO (странно вроде у всех должен быть)
    @ColumnInfo(name = "academic_department")
    @TypeConverters(ListConverter::class)
    val academicDepartment: List<String>,

    @ColumnInfo(name = "full_name")
    val fullName: String
)