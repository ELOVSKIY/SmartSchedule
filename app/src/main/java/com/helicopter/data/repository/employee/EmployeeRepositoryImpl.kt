package com.helicopter.data.repository.employee

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.EmployeeDao
import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmployeeRepositoryImpl(private val employeeDao: EmployeeDao) : EmployeeRepository {
    override suspend fun fetchEmployeeList(): LiveData<List<EmployeeEntity>> {
       refreshEmployeeList()
        return employeeDao.fetchEmployeeList()
    }

    private suspend fun refreshEmployeeList(){
        withContext(Dispatchers.IO){
            val employeeList = RetrofitClient.getListApi().fetchEmployeeList().asDatabaseEntities()
            employeeDao.insertEmployeeList(employeeList)
        }
    }

}