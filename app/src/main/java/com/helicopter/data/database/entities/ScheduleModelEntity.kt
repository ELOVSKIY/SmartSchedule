package com.helicopter.data.database.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.helicopter.data.database.entities.convertors.ListConverter
import com.helicopter.data.network.models.Employee

@Entity(tableName = "schedule_model")
@TypeConverters(ListConverter::class)
data class ScheduleModelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "schedule_model_id")
    val scheduleModelId: Long,

    val auditory: List<String>,
    @Relation(parentColumn = "schedule_model_id", entityColumn = "employee_id")
    val employee: List<EmployeeEntity>,
    val endLessonTime: String,
    @ColumnInfo(name ="lesson_time")
    val lessonTime: String,
    @ColumnInfo(name ="lesson_type")
    val lessonType: String,
    val note: String,
    @ColumnInfo(name ="num_subgroup")
    val numSubgroup: Int,
    val startLessonTime: String,
    @ColumnInfo(name ="student_group")
    val studentGroup: List<String>,
    val subject: String,
    @ColumnInfo(name ="week_number")
    val weekNumber: List<Int>,
    @SerializedName("zaoch")
    val correspondence: Boolean
)
