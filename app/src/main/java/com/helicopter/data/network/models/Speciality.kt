package com.helicopter.data.network.models

import com.helicopter.data.database.entities.SpecialityEntity

data class Speciality(
    val abbrev: String,
    val code: String,
    val educationForm: EducationForm,
    val facultyId: Long,
    val id: Long,
    val name: String
)

fun List<Speciality>.asDatabaseEntities(): List<SpecialityEntity>{
    return this.map {
        SpecialityEntity(
            it.id,
            it.abbrev,
            it.code,
            it.educationForm,
            it.facultyId,
            it.name
        )
    }
}