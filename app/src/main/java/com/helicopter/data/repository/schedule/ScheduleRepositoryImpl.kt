package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.helicopter.data.database.dao.ScheduleDao
import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.network.remote.toScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepositoryImpl(private val scheduleDao: ScheduleDao) : ScheduleRepository {

    private val _schedule = MutableLiveData<List<ScheduleModelEntity>>()
    override val schedule: LiveData<List<ScheduleModelEntity>>
        get() = _schedule

    override suspend fun fetchScheduleByGroupId(groupId: Long){
        withContext(Dispatchers.IO) {
            _schedule.value = scheduleDao.fetchScheduleListByGroupId(groupId)
            refreshScheduleByGroupId(groupId)
        }
    }

    override suspend fun fetchScheduleByGroupName(groupName: String){
        withContext(Dispatchers.IO) {
            refreshScheduleByGroupName(groupName)
            scheduleDao.fetchScheduleListByGroupName(groupName)
        }
    }

    override suspend fun fetchScheduleByEmployeeId(employeeId: Long){
        withContext(Dispatchers.IO) {
            refreshScheduleByEmployeeId(employeeId)
            scheduleDao.fetchScheduleListByEmployeeId(employeeId)
        }
    }


    private suspend fun refreshScheduleByGroupId(groupId: Long) {
        val schedule = RetrofitClient.getScheduleApi().fetchGroupScheduleById(groupId)
            .toScheduleModelEntityList()
        updateDatabase(schedule)
    }

    private suspend fun refreshScheduleByGroupName(groupName: String) {
        val schedule = RetrofitClient.getScheduleApi().fetchGroupScheduleByGroupName(groupName)
            .toScheduleModelEntityList()
        updateDatabase(schedule)
    }

    private suspend fun refreshScheduleByEmployeeId(employeeId: Long) {
        val schedule = RetrofitClient.getScheduleApi().fetchEmployeeScheduleById(employeeId)
            .toScheduleModelEntityList()
        updateDatabase(schedule)
    }

    private suspend fun updateDatabase(schedule: List<ScheduleModelEntity>){
        _schedule.value = schedule
        scheduleDao.insertScheduleList(schedule)
    }
}