package com.helicopter.ui.fragments.schedule.day

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.R
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl
import com.helicopter.domain.models.ScheduleDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class DayScheduleViewModel(
    private val app: Application,
    private val offset: Int
) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ScheduleRepositoryImpl(database)

    private val _schedule = MutableLiveData<List<ScheduleDomainModel>>()
    val schedule: LiveData<List<ScheduleDomainModel>>
        get() {
            return _schedule
        }

    init {
        fetchDaySchedule()
    }

    private fun fetchDaySchedule() {
        viewModelScope.launch(Dispatchers.Main) {
            val currentWeekNumber = repository.fetchCurrentWeekNumber()
            currentWeekNumber?.let {
                val weekDayNumber = getWeekDay()
                val weekDay = getDayByNumb(weekDayNumber)
                //TODO (1) исправить ошибку с модулями

                val extraWeek =  (weekDayNumber + offset) / 7
                val weekWithExtra = (currentWeekNumber + extraWeek) % 4
                val weekNumber = if (weekWithExtra == 0) 4 else weekWithExtra
                val weekNumberRequest = "%$weekNumber%"

                val schedule = repository.fetchCurrentSchedule(weekNumberRequest, weekDay)
                _schedule.value = schedule
            }
        }


        repository.fetchCurrentWeekNumberLive().observeForever { weekNumb ->
            weekNumb?.let {
                viewModelScope.launch(Dispatchers.Main) {
                    val weekDayNumber = getWeekDay()
                    val weekDay = getDayByNumb(weekDayNumber)

                    val extraWeek =  (weekDayNumber + offset) / 7
                    val weekWithExtra = (it + extraWeek) % 4
                    val weekNumber = if (weekWithExtra == 0) 4 else weekWithExtra
                    val weekNumberRequest = "%$weekNumber%"


                    val schedule = repository.fetchCurrentSchedule(weekNumberRequest, weekDay)
                    _schedule.value = schedule

                }
            }
        }

    }

    class Factory(
        private val app: Application, private val offset: Int
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DayScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DayScheduleViewModel(app, offset) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    private fun getWeekDay(): Int {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, offset)
        return calendar.get(Calendar.DAY_OF_WEEK)
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