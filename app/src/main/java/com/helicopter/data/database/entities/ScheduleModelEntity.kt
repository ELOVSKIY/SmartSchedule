package com.helicopter.data.database.entities

import androidx.room.*
import com.helicopter.data.database.entities.convertors.ListConverter
import com.helicopter.data.network.models.Employee
import com.helicopter.domain.models.ScheduleDomainModel

@Entity(tableName = "schedule_model",
    primaryKeys = ["group_id", "employee_id", "week_number", "week_day", "lesson_time", "num_subgroup"]
)
@TypeConverters(ListConverter::class)
data class ScheduleModelEntity(
    @ColumnInfo(name = "week_day")
    val weekDay: String,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "employee_id")
    val employeeId: Long,
    @ColumnInfo(name = "group_name")
    val groupName: String,

    val auditory: List<String>,
    @Embedded
    val employee: Employee?,
    @ColumnInfo(name = "end_lesson_time")
    val endLessonTime: String,
    @ColumnInfo(name = "lesson_time")
    val lessonTime: String,
    @ColumnInfo(name = "lesson_type")
    val lessonType: String,
    val note: String,
    @ColumnInfo(name = "num_subgroup")
    val numSubgroup: Int,
    @ColumnInfo(name = "start_lesson_time")
    val startLessonTime: String,
    @ColumnInfo(name = "student_group")
    val studentGroup: List<String>,
    val subject: String,
    @ColumnInfo(name = "week_number")
    val weekNumber: List<Int>,
    val correspondence: Boolean
)

fun ScheduleModelEntity.asDomainModel(): ScheduleDomainModel{
    return ScheduleDomainModel(
        this.groupId, this.employeeId, this.groupName, this.employee, this.subject, this.weekDay,
        this.weekNumber, this.numSubgroup, this.studentGroup, this.auditory, this.startLessonTime,
        this.endLessonTime, this.lessonTime, this.lessonType, this.note, this.correspondence
    )
}

