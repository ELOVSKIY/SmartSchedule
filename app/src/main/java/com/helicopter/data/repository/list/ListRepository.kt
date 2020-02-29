package com.helicopter.data.repository.list

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.database.utils.GroupInformation
import com.helicopter.domain.models.EmployeeDomainModel
import com.helicopter.domain.models.StudentGroupDomainModel

interface ListRepository {

    suspend fun fetchStudentGroupInformation(): List<GroupInformation>

    fun fetchStudentGroupList(): LiveData<List<StudentGroupDomainModel>>

    fun fetchEmployeeList(): LiveData<List<EmployeeDomainModel>>

    fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity>

    fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>
}