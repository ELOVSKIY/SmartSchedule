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
    fun insertEmployee(employee: EmployeeEntity)

    @Insert
    fun insertEmployeeList(staff: List<EmployeeEntity>)

    @Update
    fun updateEmployee(employee: EmployeeEntity)

    @Update
    fun updateEmployeeList(staff: List<EmployeeEntity>)

    @Query("SELECT * FROM employee WHERE employee_id = :id")
    fun getEmployeeById(id: Int): LiveData<List<EmployeeEntity>>

}