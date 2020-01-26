package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.helicopter.data.database.entities.StudentGroupEntity

@Dao
interface StudentGroupDao {

    @Insert
    suspend fun insertStudyGroup(group: StudentGroupEntity)

    @Query("SELECT * FROM student_group WHERE group_id = :groupId")
    suspend fun getStudyGroupById(groupId: Int): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group WHERE group_name = :groupName")
    suspend fun getStudyGroupByName(groupName: String): LiveData<StudentGroupEntity>
}