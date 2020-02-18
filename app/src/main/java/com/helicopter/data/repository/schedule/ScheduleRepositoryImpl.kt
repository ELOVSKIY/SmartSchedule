package com.helicopter.data.repository.schedule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.helicopter.data.database.dao.ScheduleDao
import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.network.remote.toScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class ScheduleRepositoryImpl(private val scheduleDao: ScheduleDao) : ScheduleRepository {

    private val _schedule = MutableLiveData<List<ScheduleModelEntity>>()
    override val schedule: LiveData<List<ScheduleModelEntity>>
        get() = _schedule

    override suspend fun fetchScheduleByGroupId(groupId: Long) {
        withContext(Dispatchers.IO) {
            _schedule.value = scheduleDao.fetchScheduleListByGroupId(groupId)
            refreshScheduleByGroupId(groupId)
        }
    }

    override suspend fun fetchScheduleByGroupName(groupName: String) {
        _schedule.postValue(scheduleDao.fetchScheduleListByGroupName(groupName))
        refreshScheduleByGroupName(groupName)

    }

    override suspend fun fetchScheduleByEmployeeId(employeeId: Long) {
        withContext(Dispatchers.IO) {
            _schedule.postValue(scheduleDao.fetchScheduleListByEmployeeId(employeeId))
            refreshScheduleByEmployeeId(employeeId)
        }
    }


    private suspend fun refreshScheduleByGroupId(groupId: Long) {
        try {
            val schedule = RetrofitClient.getScheduleApi().fetchGroupScheduleById(groupId)
                .toScheduleModelEntityList()
            updateDatabase(schedule)
        } catch (e: Exception) {

        }
    }

    private suspend fun refreshScheduleByGroupName(groupName: String) {
        try {
            val schedule = RetrofitClient.getScheduleApi().fetchGroupScheduleByGroupName(groupName)
                .toScheduleModelEntityList()
            updateDatabase(schedule)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private suspend fun refreshScheduleByEmployeeId(employeeId: Long) {
        try {
            val schedule = RetrofitClient.getScheduleApi().fetchEmployeeScheduleById(employeeId)
                .toScheduleModelEntityList()
            updateDatabase(schedule)
        } catch (e: Exception) {

        }
    }

    private suspend fun updateDatabase(schedule: List<ScheduleModelEntity>) {
        withContext(Dispatchers.Main){
            _schedule.value = schedule
        }
        scheduleDao.insertScheduleList(schedule)

    }
}