package com.helicopter.ui.fragments.schedule

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl
import kotlinx.coroutines.*

class ScheduleViewModel(app: Application) : ViewModel(), LifecycleObserver {
    private val database = getInstance(app)
    private val repository = ScheduleRepositoryImpl(database)


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun fetchSchedule() {
        viewModelScope.launch(Dispatchers.Main) {
            repository.updateSchedule()
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
