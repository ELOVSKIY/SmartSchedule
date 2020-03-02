package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.helicopter.data.database.entities.StudentGroupEntity
import com.helicopter.data.database.utils.StudentGroupInfoEntity

@Dao
interface StudentGroupDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertStudyGroup(group: StudentGroupEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertStudyGroupList(groups: List<StudentGroupEntity>)

    @Update
    fun updateStudyGroup(group: StudentGroupEntity)

    @Update
    fun updateStudyGroupList(groups: List<StudentGroupEntity>)

    @Query("SELECT * FROM student_group WHERE group_id = :groupId")
    fun fetchStudyGroupById(groupId: Long): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group WHERE group_name = :groupName")
    fun fetchStudyGroupByName(groupName: String): LiveData<StudentGroupEntity>

    @Query("SELECT * FROM student_group ORDER BY group_name")
    fun fetchGroupList(): LiveData<List<StudentGroupEntity>>

    @Query("SELECT * FROM student_group WHERE selected=0 ORDER BY group_name")
    fun fetchGroupInfo(): LiveData<List<StudentGroupInfoEntity>>

    @Query("SELECT * FROM student_group WHERE selected=1 ORDER BY group_name")
    fun fetchSelectedGroupInfo(): LiveData<List<StudentGroupInfoEntity>>

    @Query("UPDATE student_group SET selected=1 WHERE group_id = :groupId")
    fun selectGroupById(groupId: Long)

    @Query("UPDATE student_group SET selected=0 WHERE group_id = :groupId")
    fun unSelectGroupById(groupId: Long)

    @Query("UPDATE student_group SET mainSchedule=1 WHERE group_id =:employeeId")
    suspend fun setMainSchedule(employeeId: Long)

    @Query("UPDATE student_group SET mainSchedule=0 WHERE group_id =:employeeId")
    suspend fun removeMainScheduleById(employeeId: Long)

    @Query("UPDATE student_group SET mainSchedule=0")
    suspend fun removeMainSchedule()

    @Transaction
    suspend fun removeSelectedById(employeeId: Long){
        unSelectGroupById(employeeId)
        removeMainScheduleById(employeeId)
    }
}