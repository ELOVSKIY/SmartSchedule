package com.helicopter.data.repository.employee

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.EmployeeEntity

interface EmployeeRepository {

    suspend fun fetchEmployeeList(): LiveData<List<EmployeeEntity>>
}