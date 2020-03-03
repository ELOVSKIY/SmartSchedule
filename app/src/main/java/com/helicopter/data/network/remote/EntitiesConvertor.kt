package com.helicopter.data.network.remote

import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.network.models.Employee
import com.helicopter.data.network.models.StudentGroup
import com.helicopter.data.network.remote.response.ScheduleResponse

fun ScheduleResponse.asScheduleModelEntityList(): List<ScheduleModelEntity> {
    val schedules = this.schedules + this.examSchedules
    val scheduleModelEntities = mutableListOf<ScheduleModelEntity>()
    for (schedule in schedules) {
        for (scheduleModel in schedule.schedule) {
            val scheduleModelEntity = ScheduleModelEntity(
                schedule.weekDay, this.studentGroup?.groupId ?: 0L,
                this.employee?.employeeId ?: 0L,
                this.studentGroup?.name ?: "", scheduleModel.auditory,
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

fun List<StudentGroup>.toStudentGroupEntity(): List<StudentGroupEntity>{
    return this.map {
        StudentGroupEntity(
            it.groupId, it.name, it.facultyId, it.course, it.calendarId, it.specialityDepartmentEducationFormId
        )
    }
}

fun List<Employee>.toEmployeeEntity(): List<EmployeeEntity>{
    return this.map{
        EmployeeEntity(
            it.employeeId, it.firstName, it.lastName, it.middleName, it.rank, it.photoLink,
            it.calendarId, it.academicDepartment, it.fullName
        )
    }
}