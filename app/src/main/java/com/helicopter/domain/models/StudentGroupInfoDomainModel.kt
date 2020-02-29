package com.helicopter.domain.models

data class StudentGroupInfoDomainModel (
    val studentGroup: StudentGroupDomainModel,
    val faculty: FacultyDomainModel?,
    val speciality: SpecialityDomainModel?
)