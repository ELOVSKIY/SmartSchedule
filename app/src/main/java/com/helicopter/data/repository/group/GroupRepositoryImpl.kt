package com.helicopter.data.repository.group

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.StudentGroupDao
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GroupRepositoryImpl(private val studentGroupDao: StudentGroupDao) : GroupRepository {
    override suspend fun fetchStudentGroupList(): LiveData<List<StudentGroupEntity>> {
        refreshStudentGroupList()
        return studentGroupDao.fetchGroupList()
    }

    private suspend fun refreshStudentGroupList(){
        withContext(Dispatchers.IO){
            val groupList = RetrofitClient.getListApi().fetchGroupList()
                .asDatabaseEntities()
            studentGroupDao.insertStudyGroupList(groupList)
        }
    }
}