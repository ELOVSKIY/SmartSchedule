package com.helicopter.data.repository.schedule

import android.app.Application
import androidx.lifecycle.LiveData
import com.helicopter.data.database.database.ScheduleDatabase
import com.helicopter.data.database.entities.CurrentWeekNumberEntity
import com.helicopter.data.database.entities.asDomainModel
import com.helicopter.data.fetchSubgroupNumber
import com.helicopter.data.network.remote.asScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import com.helicopter.domain.models.ScheduleDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ScheduleRepositoryImpl(private val database: ScheduleDatabase, private val app: Application) :
    ScheduleRepository {


    override suspend fun updateSchedule() {
        withContext(Dispatchers.IO) {
            val mainGroup = database.studentGroupDao.fetchMainStudentGroupId()
            val mainEmployee = database.employeeDao.fetchMainEmployeeId()
            val scheduleApi = RetrofitClient.getScheduleApi()
            mainGroup?.let {
                try {
                    val schedule = scheduleApi.fetchGroupScheduleById(it)
                    database.currentWeekNumberDao.updateCurrentWeekNumber(
                        CurrentWeekNumberEntity(
                            weekNumber = schedule.currentWeekNumber
                        )
                    )
                    val scheduleList = schedule.asScheduleModelEntityList()
                    database.scheduleDao.insertScheduleList(scheduleList)
                }catch (e: Exception){

                }
            }
            mainEmployee?.let {
                try {
                    val schedule = scheduleApi.fetchEmployeeScheduleById(it)
                    database.currentWeekNumberDao.updateCurrentWeekNumber(
                        CurrentWeekNumberEntity(
                            weekNumber = schedule.currentWeekNumber
                        )
                    )
                    val scheduleList = schedule.asScheduleModelEntityList()
                    database.scheduleDao.insertScheduleList(scheduleList)
                }catch (e: Exception){

                }
            }
        }
    }

    suspend fun fetchCurrentSchedule(weekNumber: String, day: String): List<ScheduleDomainModel>? {
        return withContext(Dispatchers.IO) {
            val mainGroup = database.studentGroupDao.fetchMainStudentGroupId()
            val mainEmployee = database.employeeDao.fetchMainEmployeeId()
            mainGroup?.let { groupId ->
                val subgroupNumber = fetchSubgroupNumber(app)
                return@withContext database.scheduleDao.fetchScheduleListByGroupIdAndWeek(
                    groupId,
                    subgroupNumber,
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

    fun fetchCurrentWeekNumberLive(): LiveData<Int> {
        return database.currentWeekNumberDao.fetchCurrentWeekNumberLive()
    }

    suspend fun fetchCurrentWeekNumber(): Int? {
        return database.currentWeekNumberDao.fetchCurrentWeekNumber()
    }


}