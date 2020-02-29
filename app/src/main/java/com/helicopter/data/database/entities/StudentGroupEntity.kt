package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.helicopter.domain.models.StudentGroupDomainModel

//CORRECT ENTITY
@Entity(tableName = "student_group")
data class StudentGroupEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "group_name")
    val name: String,
    @ColumnInfo(name = "faculty_id")
    val facultyId: Long,
    val course: Int,
    @ColumnInfo(name = "calendar_id")
    val calendarId: String?,
    @ColumnInfo(name = "speciality_department_education_form_id")
    val specialityDepartmentEducationFormId: Int,
    val selected: Boolean = false,
    val mainSchedule : Boolean = false
)

fun List<StudentGroupEntity>.asDomainModel(): List<StudentGroupDomainModel> {
    return this.map {
        StudentGroupDomainModel(
            it.groupId, it.name, it.course, it.calendarId
        )
    }
}

fun StudentGroupEntity.asDomainModel(): StudentGroupDomainModel {
    return StudentGroupDomainModel(
        this.groupId, this.name, this.course, this.calendarId
    )

}