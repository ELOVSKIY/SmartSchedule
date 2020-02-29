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

    fun fetchStudentGroupList(): LiveData<List<StudentGroupDomainModel>>

    fun fetchEmployeeList(): LiveData<List<EmployeeDomainModel>>

    fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity>

    fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>

    suspend fun selectStudentGroup(groupId: Long)
}