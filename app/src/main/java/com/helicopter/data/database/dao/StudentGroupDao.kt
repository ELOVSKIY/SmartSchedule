package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.helicopter.data.database.entities.StudentGroupEntity

@Dao
interface StudentGroupDao {

    @Insert
    fun insertStudyGroup(group: StudentGroupEntity)

    @Insert
    fun insertStudyGroupList(groups: List<StudentGroupEntity>)

    @Update
    fun updateStudyGroup(group: StudentGroupEntity)

    @Update
    fun updateStudyGroupList(groups: List<StudentGroupEntity>)

    @Query("SELECT * FROM student_group WHERE group_id = :groupId")
    fun fetchStudyGroupById(groupId: Int): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group WHERE group_name = :groupName")
    fun fetchStudyGroupByName(groupName: String): LiveData<StudentGroupEntity>
}