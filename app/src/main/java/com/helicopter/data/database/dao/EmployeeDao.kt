package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.helicopter.data.database.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insertEmployee(employee: EmployeeEntity)

    @Insert
    suspend fun insertEmployeeList(staff: List<EmployeeEntity>)

    @Update
    suspend fun updateEmployee(employee: EmployeeEntity)

    @Update
    suspend fun updateEmployeeList(staff: List<EmployeeEntity>)

    @Query("SELECT * FROM employee WHERE employee_id = :id")
    suspend fun getEmployeeById(id: Int) : LiveData<EmployeeEntity>

}