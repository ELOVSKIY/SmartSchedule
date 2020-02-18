package com.helicopter.ui.fragments.schedule

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl
import kotlinx.coroutines.*

class ScheduleViewModel(private val app: Application) : ViewModel() {
    private val database = getInstance(app)
    private val repository = ScheduleRepositoryImpl(database.scheduleDao)

    val schedule = repository.schedule

    fun fetchSchedule() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchScheduleByGroupName("851001")
        }
    }

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ScheduleViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
