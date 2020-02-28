package com.helicopter.data.repository.list

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.entities.StudentGroupEntity

interface ListRepository {

    suspend fun fetchStudentGroupList(): LiveData<List<StudentGroupEntity>>

    suspend fun fetchEmployeeList(): LiveData<List<EmployeeEntity>>

    suspend fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    suspend fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity>

    suspend fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    suspend fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>
}