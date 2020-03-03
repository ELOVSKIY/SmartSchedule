package com.helicopter.ui.fragments.schedule.day

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl

class DayScheduleViewModel(app: Application): ViewModel() {

    private val database = getInstance(app)
    private val repository = ScheduleRepositoryImpl(database)

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DayScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DayScheduleViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}