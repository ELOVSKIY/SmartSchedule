package com.helicopter.data.repository.auditory

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.AuditoryDao
import com.helicopter.data.database.entities.AuditoryEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuditoryRepositoryImpl(private val auditoryDao: AuditoryDao) : AuditoryRepository {
    override suspend fun fetchAuditoryList(): LiveData<List<AuditoryEntity>> {
        refreshAuditory()
        return auditoryDao.fetchAuditoryList()
    }

    private suspend fun refreshAuditory(){
        withContext(Dispatchers.IO){
            val auditory = RetrofitClient.getListApi().fetchAuditoryList()
                .asDatabaseEntities()
            auditoryDao.insertAuditoryList(auditory)
        }
    }
}