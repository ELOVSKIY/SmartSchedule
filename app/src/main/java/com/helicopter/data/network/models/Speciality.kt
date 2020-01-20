package com.helicopter.data.network.models

data class Speciality(
    val abbrev: String,
    val code: String,
    val educationForm: EducationForm,
    val facultyId: Int,
    val id: Int,
    val name: String
)