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
    //TODO(РАЗОЮРАТСЬЯ С ЭТИМ)
    val employee: List<EmployeeEntity>,
    @ColumnInfo(name="end_lesson_time")
    val endLessonTime: String,
    @ColumnInfo(name ="lesson_time")
    val lessonTime: String,
    @ColumnInfo(name ="lesson_type")
    val lessonType: String,
    val note: String,
    @ColumnInfo(name ="num_subgroup")
    val numSubgroup: Int,
    @ColumnInfo(name ="start_lesson_time")
    val startLessonTime: String,
    @ColumnInfo(name ="student_group")
    //TODO(СПИСОК ГРУПП, ПРИХОДИТ МАССИВ)
    val studentGroup: String,
    val subject: String,
    @ColumnInfo(name ="week_number")
    val weekNumber: List<Int>,
    @SerializedName("zaoch")
    val correspondence: Boolean
)
