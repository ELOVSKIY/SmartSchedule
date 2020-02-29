package com.helicopter.data.database.utils

import androidx.room.Embedded
import androidx.room.Relation
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.database.entities.asDomainModel
import com.helicopter.domain.models.StudentGroupInfoDomainModel as StudentGroupInfoDomainModel1

data class StudentGroupInfoEntity (
    @Embedded
    val studentGroup: StudentGroupEntity,

    @Relation(parentColumn = "faculty_id", entityColumn = "faculty_id", entity = FacultyEntity::class)
    val faculty: FacultyEntity?,

    @Relation(parentColumn = "speciality_department_education_form_id", entityColumn = "speciality_id", entity = SpecialityEntity::class)
    val speciality: SpecialityEntity?

)

fun StudentGroupInfoEntity.asDomainModel(): StudentGroupInfoDomainModel1 {
    return StudentGroupInfoDomainModel1(this.studentGroup.asDomainModel(),
        this.faculty?.asDomainModel(), this.speciality?.asDomainModel())
}

fun List<StudentGroupInfoEntity>.asDomainModel(): List<StudentGroupInfoDomainModel1> {
    return this.map {
        it.asDomainModel()
    }
}