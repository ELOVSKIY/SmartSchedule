package com.helicopter.data.repository.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.helicopter.data.database.database.ScheduleDatabase
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.database.entities.asDomainModel
import com.helicopter.data.database.utils.asDomainModel
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import com.helicopter.domain.models.EmployeeDomainModel
import com.helicopter.domain.models.StudentGroupInfoDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Exception

private const val TRY_AGAIN_TIMEOUT = 2_000L

class ListRepositoryImpl(private val database: ScheduleDatabase) : ListRepository{


    override fun fetchStudentGroupInfo(): LiveData<List<StudentGroupInfoDomainModel>> {
        return Transformations.map(database.studentGroupDao.fetchGroupInfo()){
                it.asDomainModel()
        }
    }

    override fun fetchSelectedGroupInfo(): LiveData<List<StudentGroupInfoDomainModel>> {
        return Transformations.map(database.studentGroupDao.fetchSelectedGroupInfo()){
            it.asDomainModel()
        }
    }

    override fun fetchEmployeeList(): LiveData<List<EmployeeDomainModel>> {
        return Transformations.map(database.employeeDao.fetchEmployeeList()){
            it.asDomainModel()
        }
    }

    override fun fetchSelectedEmployeeList(): LiveData<List<EmployeeDomainModel>> {
        return Transformations.map(database.employeeDao.fetchSelectedEmployeeList()){
            it.asDomainModel()
        }
    }

    override fun fetchFacultyList(): LiveData<List<FacultyEntity>> {
        return database.facultyDao.fetchFacultyList()
    }

    override fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity> {
        return database.facultyDao.fetchFacultyById(facultyId)
    }

    override fun fetchSpecialityList(): LiveData<List<SpecialityEntity>> {
        return database.specialityDao.fetchSpecialityList()
    }

    override fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity> {
        return database.specialityDao.fetchSpecialityById(specialityId)
    }

    suspend fun refreshStudentGroupInfo(){
        refreshFacultyList()
        refreshSpecialityList()
        refreshStudentGroupList()
    }

    suspend fun refreshStudentGroupList(){
        try {
            withContext(Dispatchers.IO) {
                val groupList = RetrofitClient.getListApi().fetchGroupList()
                    .asDatabaseEntities()
                database.studentGroupDao.insertStudyGroupList(groupList)
            }
        }catch (e: Exception){
            delay(TRY_AGAIN_TIMEOUT)
            refreshStudentGroupList()
        }
    }

    suspend fun refreshFacultyList(){
        try {
            withContext(Dispatchers.IO) {
                val faculties = RetrofitClient.getListApi().fetchFacultyList().asDatabaseEntities()
                database.facultyDao.insertFacultyList(faculties)
            }
        }catch (e: Exception){
            delay(TRY_AGAIN_TIMEOUT)
            refreshFacultyList()
        }
    }

    suspend fun refreshEmployeeList(){
        withContext(Dispatchers.IO){
            try {
                val employeeList =
                    RetrofitClient.getListApi().fetchEmployeeList().asDatabaseEntities()
                database.employeeDao.insertEmployeeList(employeeList)
            }catch (e: Exception){
                delay(TRY_AGAIN_TIMEOUT)
                refreshEmployeeList()
            }
        }
    }

    suspend fun refreshSpecialityList(){
        withContext(Dispatchers.IO){
            try {
                val specialities = RetrofitClient.getListApi().fetchSpecialityList()
                    .asDatabaseEntities()
                database.specialityDao.insertSpecialityList(specialities)
            }catch (e: Exception){
                delay(TRY_AGAIN_TIMEOUT)
                refreshSpecialityList()
            }
        }
    }

    override suspend fun selectStudentGroup(groupId: Long) {
        withContext(Dispatchers.IO){
            database.studentGroupDao.selectGroupById(groupId)
        }
    }

    override suspend fun unSelectStudentGroup(groupId: Long) {
        withContext(Dispatchers.IO){
            database.studentGroupDao.unSelectGroupById(groupId)
        }
    }

    override suspend fun selectEmployee(employeeId: Long) {
        withContext(Dispatchers.IO){
            database.employeeDao.selectEmployeeById(employeeId)
        }
    }

    override suspend fun unSelectEmployee(employeeId: Long) {
        withContext(Dispatchers.IO){
            database.employeeDao.unSelectEmployeeById(employeeId)
        }
    }
}