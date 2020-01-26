package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "schedule")
class ScheduleEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "schedule_entity_id")
    val scheduleEntityId: Long,

    @Relation(parentColumn = "schedule_entity_id", entityColumn = "schedule_model_id")
    val schedule: List<ScheduleModelEntity>,

    @ColumnInfo(name = "week_day")
    val weekDay: String,

    @ColumnInfo(name = "group_id")
    val groupId: Int,

    @ColumnInfo(name = "group_name")
    val groupNumb: String
)