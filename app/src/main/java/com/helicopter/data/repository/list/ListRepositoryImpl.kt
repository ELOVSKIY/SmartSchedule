package com.helicopter.data.repository.list

import androidx.lifecycle.LiveData
import com.helicopter.data.database.database.ScheduleDatabase
import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListRepositoryImpl(private val database: ScheduleDatabase) : ListRepository{
    override suspend fun fetchStudentGroupList(): LiveData<List<StudentGroupEntity>> {
        refreshStudentGroupList()
        return database.studentGroupDao.fetchGroupList()
    }

    override suspend fun fetchEmployeeList(): LiveData<List<EmployeeEntity>> {
        refreshEmployeeList()
        return database.employeeDao.fetchEmployeeList()
    }

    override suspend fun fetchFacultyList(): LiveData<List<FacultyEntity>> {
        refreshFacultyList()
        return database.facultyDao.fetchFacultyList()
    }

    override suspend fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity> {
        refreshFacultyList()
        return database.facultyDao.fetchFacultyByid(facultyId)
    }

    override suspend fun fetchSpecialityList(): LiveData<List<SpecialityEntity>> {
        refreshSpecialityList()
        return database.specialityDao.fetchSpecialityList()
    }

    override suspend fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity> {
        refreshSpecialityList()
        return database.specialityDao.fetchSpecialityById(specialityId)
    }

    private suspend fun refreshStudentGroupList(){
        withContext(Dispatchers.IO){
            val groupList = RetrofitClient.getListApi().fetchGroupList()
                .asDatabaseEntities()
            database.studentGroupDao.insertStudyGroupList(groupList)
        }
    }

    private suspend fun refreshFacultyList(){
        withContext(Dispatchers.IO){
            val faculties = RetrofitClient.getListApi().fetchFacultyList().asDatabaseEntities()
            database.facultyDao.insertFacultyList(faculties)
        }
    }


    private suspend fun refreshEmployeeList(){
        withContext(Dispatchers.IO){
            val employeeList = RetrofitClient.getListApi().fetchEmployeeList().asDatabaseEntities()
            database.employeeDao.insertEmployeeList(employeeList)
        }
    }

    private suspend fun refreshSpecialityList(){
        withContext(Dispatchers.IO){
            val specialities = RetrofitClient.getListApi().fetchSpecialityList()
                .asDatabaseEntities()
            database.specialityDao.insertSpecialityList(specialities)
        }
    }
}