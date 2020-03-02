package com.helicopter.data.repository.list

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.utils.StudentGroupInfoEntity
import com.helicopter.domain.models.EmployeeDomainModel
import com.helicopter.domain.models.StudentGroupDomainModel
import com.helicopter.domain.models.StudentGroupInfoDomainModel

interface ListRepository {

    fun fetchStudentGroupInfo():  LiveData<List<StudentGroupInfoDomainModel>>

    fun fetchSelectedGroupInfo(): LiveData<List<StudentGroupInfoDomainModel>>

    fun fetchEmployeeList(): LiveData<List<EmployeeDomainModel>>

    fun fetchSelectedEmployeeList(): LiveData<List<EmployeeDomainModel>>

    fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity>

    fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>

    suspend fun selectStudentGroup(groupId: Long)

    suspend fun unSelectStudentGroup(groupId: Long)

    suspend fun selectEmployee(employeeId: Long)

    suspend fun unSelectEmployee(employeeId: Long)

    suspend fun setMainEmployeeSchedule(employeeId: Long)

    suspend fun setMainStudentGroupSchedule(groupId: Long)
}