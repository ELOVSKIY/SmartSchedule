package com.helicopter.ui.fragments.schedule.day

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.R
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.database.entities.ScheduleModelEntity
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl
import com.helicopter.domain.models.ScheduleDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayScheduleViewModel(
    private val app: Application,
    private val date: String,
    private val dayNumber: Int,
    private val offset: Int
) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ScheduleRepositoryImpl(database)

    private val _schedule = MutableLiveData<List<ScheduleDomainModel>>()
    val schedule: LiveData<List<ScheduleDomainModel>>
        get() {
            return _schedule
        }

    suspend fun fetchDaySchedule() {
        repository.fetchCurrentWeekNumber().observeForever(Observer { weekNumb ->
            weekNumb?.let {
                viewModelScope.launch(Dispatchers.Main) {
                    val weekNumber = (it + (dayNumber + offset) / 7) % 4
                    val weekDay = getDayByNumb((dayNumber + offset) % 7)
                    val schedule = repository.fetchCurrentSchedule(weekNumber, weekDay)
                    _schedule.value = schedule

                }
            }
        })

    }

    class Factory(
        private val app: Application, private val date: String,
        private val dayNumber: Int, private val offset: Int
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DayScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DayScheduleViewModel(app, date, dayNumber, offset) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    private fun getDayByNumb(day: Int): String {
        return when (day) {
            1 -> app.getString(R.string.sunday)
            2 -> app.getString(R.string.monday)
            3 -> app.getString(R.string.tuesday)
            4 -> app.getString(R.string.wednesday)
            5 -> app.getString(R.string.thursday)
            6 -> app.getString(R.string.friday)
            7 -> app.getString(R.string.saturday)
            else -> throw java.lang.IllegalArgumentException()
        }
    }
}