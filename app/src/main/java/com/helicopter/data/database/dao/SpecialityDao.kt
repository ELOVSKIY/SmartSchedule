package com.helicopter.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helicopter.data.database.entities.SpecialityEntity

@Dao
interface SpecialityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpecialityList(specialityList: List<SpecialityEntity>)

    @Query("SELECT * FROM speciality")
    fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    @Query("SELECT * FROM speciality WHERE speciality_id =:specialityId")
    fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>
}