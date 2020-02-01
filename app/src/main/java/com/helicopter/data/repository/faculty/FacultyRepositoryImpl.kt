package com.helicopter.data.repository.faculty

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.FacultyDao
import com.helicopter.data.database.entities.FacultyEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FacultyRepositoryImpl(private val facultyDao: FacultyDao) : FacultyRepository {
    override suspend fun fetchFacultyList(): LiveData<List<FacultyEntity>> {
        refreshFacultyList()
        return facultyDao.fetchFacultyList()
    }

    override suspend fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity> {
        return facultyDao.fetchFacultyByid(facultyId)
    }

    private suspend fun refreshFacultyList(){
        withContext(Dispatchers.IO){
            val faculties = RetrofitClient.getListApi().fetchFacultyList().asDatabaseEntities()
            facultyDao.insertFacultyList(faculties)
        }
    }
}