package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import com.helicopter.data.database.database.ScheduleDatabase
import com.helicopter.data.database.entities.CurrentWeekNumberEntity
import com.helicopter.data.database.entities.asDomainModel
import com.helicopter.data.network.remote.asScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import com.helicopter.domain.models.ScheduleDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepositoryImpl(private val database: ScheduleDatabase) : ScheduleRepository {


    override suspend fun updateSchedule() {
        withContext(Dispatchers.IO) {
            val mainGroup = database.studentGroupDao.fetchMainStudentGroupId()
            val mainEmployee = database.employeeDao.fetchMainEmployeeId()
            val scheduleApi = RetrofitClient.getScheduleApi()
            mainGroup?.let {
                val schedule = scheduleApi.fetchGroupScheduleById(it)
                database.currentWeekNumberDao.updateCurrentWeekNumber(
                    CurrentWeekNumberEntity(
                        weekNumber = schedule.currentWeekNumber
                    )
                )
                val scheduleList = schedule.asScheduleModelEntityList()
                database.scheduleDao.insertScheduleList(scheduleList)
            }
            mainEmployee?.let {
                val schedule = scheduleApi.fetchEmployeeScheduleById(it)
                database.currentWeekNumberDao.updateCurrentWeekNumber(
                    CurrentWeekNumberEntity(
                        weekNumber = schedule.currentWeekNumber
                    )
                )
                val scheduleList = schedule.asScheduleModelEntityList()
                database.scheduleDao.insertScheduleList(scheduleList)
            }
        }
    }

    suspend fun fetchCurrentSchedule(weekNumber: Int, day: String): List<ScheduleDomainModel>? {
        return withContext(Dispatchers.IO) {
            val mainGroup = database.studentGroupDao.fetchMainStudentGroupId()
            val mainEmployee = database.employeeDao.fetchMainEmployeeId()
            mainGroup?.let { groupId ->
                return@withContext database.scheduleDao.fetchScheduleListByGroupIdAndWeek(
                    groupId,
                    weekNumber,
                    day
                )
                    .map { it.asDomainModel() }
            }
            mainEmployee?.let { employeeId ->
                return@withContext database.scheduleDao.fetchScheduleByEmployeeIdAndWeek(
                    employeeId,
                    weekNumber,
                    day
                )
                    .map { it.asDomainModel() }
            }
            return@withContext null
        }
    }

    fun fetchCurrentWeekNumber(): LiveData<Int> {
        return database.currentWeekNumberDao.fetchCurrentWeekNumberLive()
    }


}