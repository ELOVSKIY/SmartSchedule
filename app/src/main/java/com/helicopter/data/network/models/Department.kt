package com.helicopter.data.network.models

import com.google.gson.annotations.SerializedName

data class Department(
    val abbrev: String,
    @SerializedName("idDepartment")
    val departmentId: Long,
    val name: String,
    val nameAndAbbrev: String
)