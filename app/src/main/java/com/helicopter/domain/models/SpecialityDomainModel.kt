package com.helicopter.domain.models

import com.helicopter.data.network.models.EducationForm

data class SpecialityDomainModel(
//    val id: Long,
    val abbrev: String,
    val code: String,
    val educationForm: EducationForm,
    val facultyId: Long,
    val name: String
)