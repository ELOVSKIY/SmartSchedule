package com.helicopter.data.repository.schedule

import com.helicopter.data.database.database.ScheduleDatabase
import com.helicopter.data.database.entities.CurrentWeekNumberEntity
import com.helicopter.data.network.remote.asScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepositoryImpl(private val database: ScheduleDatabase) : ScheduleRepository {


    override suspend fun updateSchedule(){
        withContext(Dispatchers.IO){
            val mainGroup = database.studentGroupDao.fetchMainStudentGroupId()
            val mainEmployee = database.employeeDao.fetchMainEmployeeId()
            val scheduleApi = RetrofitClient.getScheduleApi()
            mainGroup?.let{
                val schedule = scheduleApi.fetchGroupScheduleById(it)
                database.currentWeekNumberDao.updateCurrentWeekNumber(CurrentWeekNumberEntity(
                    weekNumber = schedule.currentWeekNumber))
                val scheduleList = schedule.asScheduleModelEntityList()
                database.scheduleDao.insertScheduleList(scheduleList)
            }
            mainEmployee?.let {
                val schedule = scheduleApi.fetchEmployeeScheduleById(it)
                database.currentWeekNumberDao.updateCurrentWeekNumber(CurrentWeekNumberEntity(
                    weekNumber = schedule.currentWeekNumber))
                val scheduleList = schedule.asScheduleModelEntityList()
                database.scheduleDao.insertScheduleList(scheduleList)
            }
        }
    }
}