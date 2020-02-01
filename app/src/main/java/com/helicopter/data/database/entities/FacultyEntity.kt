package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculty")
data class FacultyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "faculty_id")
    val id: Long,

    val abbrev: String,
    val name: String
)