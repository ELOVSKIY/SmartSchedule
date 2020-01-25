package com.helicopter.data.network.models


import com.google.gson.annotations.SerializedName

data class Auditory(
    val id: Int,
    val name: String,
    val note: String?,
    val capacity: String?,
    val auditoryType: AuditoryType,
    val buildingNumber: BuildingNumber,
    val department: Department
)