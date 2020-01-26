package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.helicopter.data.database.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee WHERE employee_id = :id")
    suspend fun getEmployeeById(id: Int) : LiveData<EmployeeEntity>

}