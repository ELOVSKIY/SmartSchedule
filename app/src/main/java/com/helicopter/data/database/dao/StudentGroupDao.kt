package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.database.utils.GroupInformation

@Dao
interface StudentGroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudyGroup(group: StudentGroupEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudyGroupList(groups: List<StudentGroupEntity>)

    @Update
    fun updateStudyGroup(group: StudentGroupEntity)

    @Update
    fun updateStudyGroupList(groups: List<StudentGroupEntity>)

    @Query("SELECT * FROM student_group WHERE group_id = :groupId")
    fun fetchStudyGroupById(groupId: Int): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group WHERE group_name = :groupName")
    fun fetchStudyGroupByName(groupName: String): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group ORDER BY group_name")
    fun fetchGroupList(): LiveData<List<StudentGroupEntity>>

    @Query("SELECT * FROM student_group")
    suspend fun fetchWithGroupInfo(): List<GroupInformation>
}