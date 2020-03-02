package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.helicopter.data.database.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    //TODO (переделать структурру бд под реплэйс)
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertEmployee(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertEmployeeList(staff: List<EmployeeEntity>)

    @Update
    fun updateEmployee(employee: EmployeeEntity)

    @Update
    fun updateEmployeeList(staff: List<EmployeeEntity>)

    @Query("SELECT * FROM employee WHERE employee_id = :id")
    fun fetchEmployeeById(id: Int): LiveData<EmployeeEntity>

    @Query("SELECT * FROM employee WHERE selected=0 ORDER BY full_name")
    fun fetchEmployeeList(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE selected=1 ORDER BY full_name")
    fun fetchSelectedEmployeeList(): LiveData<List<EmployeeEntity>>

    @Query("UPDATE employee SET selected=1 WHERE employee_id = :employeeId")
    suspend fun selectEmployeeById(employeeId: Long)

    @Query("UPDATE employee SET selected=0 WHERE employee_id = :employeeId")
    suspend fun unSelectEmployeeById(employeeId: Long)

    @Query("UPDATE employee SET mainSchedule=1 WHERE employee_id =:employeeId")
    suspend fun setMainEmployeeSchedule(employeeId: Long)

    @Query("UPDATE employee SET mainSchedule=0 WHERE employee_id =:employeeId")
    suspend fun removeMainScheduleById(employeeId: Long)

    @Query("UPDATE student_group SET mainSchedule=0")
    suspend fun removeMainStudentGroupSchedule()

    @Query("UPDATE employee SET mainSchedule=0")
    suspend fun removeMainEmployeeSchedule()

    @Transaction
    suspend fun removeSelectedById(employeeId: Long){
        unSelectEmployeeById(employeeId)
        removeMainScheduleById(employeeId)
    }

    @Transaction
    suspend fun setMainSchedule(groupId: Long){
        removeMainStudentGroupSchedule()
        removeMainEmployeeSchedule()
        setMainEmployeeSchedule(groupId)
    }


}