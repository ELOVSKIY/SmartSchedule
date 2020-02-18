package com.helicopter.data.repository.auditory

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.AuditoryEntity

interface AuditoryRepository {

    suspend fun fetchAuditoryList(): LiveData<List<AuditoryEntity>>
}