package com.helicopter.data.network.models

import com.helicopter.data.database.entities.AuditoryEntity


data class Auditory(
    val id: Long,
    val name: String,
    val note: String?,
    val capacity: String?,
    val auditoryType: AuditoryType,
    val buildingNumber: BuildingNumber,
    val department: Department
)

fun List<Auditory>.asDatabaseEntities(): List<AuditoryEntity>{
    return this.map { AuditoryEntity(
        it.id,
        it.name,
        it.note,
        it.capacity,
        it.auditoryType,
        it.buildingNumber,
        it.department
    ) }
}