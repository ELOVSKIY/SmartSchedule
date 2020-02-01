package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.helicopter.data.network.models.EducationForm

@Entity(tableName = "speciality")
data class SpecialityEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "speciality_id")
    val id: Long,
    val abbrev: String,
    val code: String,
    @Embedded(prefix = "education_form")
    val educationForm: EducationForm,
    @ColumnInfo(name = "faculty_id")
    val facultyId: Long,
    val name: String
)