package com.helicopter.data.repository.group

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.StudentGroupEntity

interface GroupRepository {

    suspend fun fetchStudentGroupList(): LiveData<List<StudentGroupEntity>>
}