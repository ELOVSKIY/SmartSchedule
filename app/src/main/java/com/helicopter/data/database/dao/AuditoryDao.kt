package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.AuditoryEntity

@Dao
interface AuditoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAuditoryList(auditoryList: List<AuditoryEntity>)

    @Query("SELECT * FROM auditory")
    fun fetchAuditoryList(): LiveData<List<AuditoryEntity>>
}