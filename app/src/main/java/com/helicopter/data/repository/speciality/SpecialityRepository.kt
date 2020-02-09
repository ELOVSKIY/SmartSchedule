package com.helicopter.data.repository.speciality

import androidx.lifecycle.LiveData
import com.helicopter.data.database.entities.SpecialityEntity

interface SpecialityRepository {

    suspend fun fetchSpecialityList(): LiveData<List<SpecialityEntity>>

    suspend fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity>
}