package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.helicopter.data.database.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployeeList(staff: List<EmployeeEntity>)

    @Update
    fun updateEmployee(employee: EmployeeEntity)

    @Update
    fun updateEmployeeList(staff: List<EmployeeEntity>)

    @Query("SELECT * FROM employee WHERE employee_id = :id")
    fun fetchEmployeeById(id: Int): LiveData<EmployeeEntity>

    @Query("SELECT * FROM employee WHERE selected=0 ORDER BY last_name")
    fun fetchEmployeeList(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE selected=1 ORDER BY last_name")
    fun fetchSelectedEmployeeList(): LiveData<List<EmployeeEntity>>

    @Query("UPDATE employee SET selected=NOT selected WHERE employee_id = :employeeId")
    suspend fun changeSelectedStatusById(employeeId: Long)
}