package com.helicopter.data.network.remote

import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.network.remote.response.ScheduleResponse

fun ScheduleResponse.toScheduleModelEntityList(): List<ScheduleModelEntity> {
    val schedules = this.schedules + this.examSchedules
    val scheduleModelEntities = mutableListOf<ScheduleModelEntity>()
    for (schedule in schedules) {
        for (scheduleModel in schedule.schedule) {
            val scheduleModelEntity = ScheduleModelEntity(
                0L, schedule.weekDay, this.studentGroup?.groupId,
                this.employee?.employeeId,
                this.studentGroup?.name, scheduleModel.auditory,
                if (scheduleModel.employee.isNotEmpty()) scheduleModel.employee[0] else null,
                scheduleModel.endLessonTime, scheduleModel.lessonTime, scheduleModel.lessonType,
                scheduleModel.note ?: "", scheduleModel.numSubgroup, scheduleModel.startLessonTime,
                scheduleModel.studentGroup, scheduleModel.subject, scheduleModel.weekNumber,
                scheduleModel.correspondence
            )
            scheduleModelEntities.add(scheduleModelEntity)
        }
    }
    return scheduleModelEntities
}