package com.helicopter.data.repository.schedule

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.ScheduleDao
import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.network.remote.toScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepositoryImpl(private val scheduleDao: ScheduleDao): ScheduleRepository{


    override suspend fun fetchScheduleByGroupId(groupId: Long): LiveData<List<ScheduleModelEntity>>{
        refreshScheduleByGroupId(groupId)
        return scheduleDao.fetchScheduleListByGroupId(groupId)
    }

    override suspend fun fetchScheduleByGroupName(groupName: String): LiveData<List<ScheduleModelEntity>>{
        refreshScheduleByGroupName(groupName)
//        return scheduleDao.fetchScheduleListByGroupName(groupName)
        TODO()
    }

    override suspend fun fetchScheduleByEmployeeId(employeeId: Long): LiveData<List<ScheduleModelEntity>>{
        refreshScheduleByEmployeeId(employeeId)
        TODO()
//        return scheduleDao.fetchScheduleListByEmployeeId(employeeId)
    }


    private suspend fun refreshScheduleByGroupId(groupId: Long){
        withContext(Dispatchers.IO){
            val schedule
                    = RetrofitClient.getScheduleApi().fetchGroupScheduleById(groupId).toScheduleModelEntityList()
            scheduleDao.insertScheduleList(schedule)
        }
    }

    private suspend fun refreshScheduleByGroupName(groupName: String){
        withContext(Dispatchers.IO){
            val schedule
                    = RetrofitClient.getScheduleApi().fetchGroupScheduleByGroupName(groupName).toScheduleModelEntityList()
            scheduleDao.insertScheduleList(schedule)
        }
    }

    private suspend fun refreshScheduleByEmployeeId(employeeId: Long){
        withContext(Dispatchers.IO){
            val schedule
                    = RetrofitClient.getScheduleApi().fetchEployeeScheduleById(employeeId).toScheduleModelEntityList()
            scheduleDao.insertScheduleList(schedule)
        }
    }
}