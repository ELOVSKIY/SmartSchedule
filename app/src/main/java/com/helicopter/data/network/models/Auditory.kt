package com.helicopter.data.network.models


data class Auditory(
    val id: Int,
    val name: String,
    val note: String?,
    val capacity: String?,
    val auditoryType: AuditoryType,
    val buildingNumber: BuildingNumber,
    val department: Department
)