package com.helicopter.data.network.models

data class Speciality(
    val abbrev: String,
    val code: String,
    val educationForm: EducationForm,
    val facultyId: Long,
    val id: Long,
    val name: String
)