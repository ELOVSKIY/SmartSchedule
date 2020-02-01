package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.helicopter.data.network.models.AuditoryType
import com.helicopter.data.network.models.BuildingNumber
import com.helicopter.data.network.models.Department

@Entity(tableName = "auditory")
data class AuditoryEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "auditory_id")
    val auditoryId: Long,
    val name: String,
    val note: String?,
    val capacity: String?,
    @Embedded(prefix = "auditory_type_")
    @ColumnInfo(name="auditory_type")
    val auditoryType: AuditoryType,
    @Embedded(prefix = "building_number_")
    @ColumnInfo(name = "building_number")
    val buildingNumber: BuildingNumber,
    @Embedded(prefix = "department_")
    val department: Department
)