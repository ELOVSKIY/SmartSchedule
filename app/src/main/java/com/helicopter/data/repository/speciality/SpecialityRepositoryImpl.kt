package com.helicopter.data.repository.speciality

import androidx.lifecycle.LiveData
import com.helicopter.data.database.dao.SpecialityDao
import com.helicopter.data.database.entities.SpecialityEntity
import com.helicopter.data.network.models.asDatabaseEntities
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpecialityRepositoryImpl(private val specialityDao: SpecialityDao) : SpecialityRepository {
    override suspend fun fetchSpecialityList(): LiveData<List<SpecialityEntity>> {
        refreshSpecialityList()
        return specialityDao.fetchSpecialityList()
    }

    override suspend fun fetchSpecialityById(specialityId: Long): LiveData<SpecialityEntity> {
       refreshSpecialityList()
        return specialityDao.fetchSpecialityById(specialityId)
    }

    private suspend fun refreshSpecialityList(){
        withContext(Dispatchers.IO){
            val specialities = RetrofitClient.getListApi().fetchSpecialityList()
                .asDatabaseEntities()
            specialityDao.insertSpecialityList(specialities)
        }
    }
}