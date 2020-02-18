package com.helicopter.data.repository.faculty

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.FacultyEntity

interface FacultyRepository {
    suspend fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    suspend fun fetchFacultyById(facultyId: Long): LiveData<FacultyEntity>
}