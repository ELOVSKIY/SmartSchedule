package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.FacultyEntity

@Dao
interface FacultyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFacultyList(facultyList: List<FacultyEntity>)

    @Query("SELECT * FROM faculty")
    fun fetchFacultyList(): LiveData<List<FacultyEntity>>

    @Query("SELECT * FROM faculty WHERE faculty_id =:facultyId")
    fun fetchFacultyByid(facultyId: Long): LiveData<FacultyEntity>
}