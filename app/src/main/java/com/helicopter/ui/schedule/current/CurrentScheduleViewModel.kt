package com.helicopter.ui.schedule.current

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.network.remote.toScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.*

class CurrentScheduleViewModel(private val app: Application) : ViewModel() {
    private val database = getInstance(app)


    fun fetchSchedule() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val db = getInstance(app).scheduleDao
                val schedule = RetrofitClient.getScheduleApi().fetchEmployeeScheduleById(500590)
                    .toScheduleModelEntityList()
                db.insertScheduleList(schedule)
                val s = db.fetchScheduleListByEmployeeId(500590)
                val е = db.fetchScheduleListByGroupName("851001")
            }
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CurrentScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CurrentScheduleViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
