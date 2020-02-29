package com.helicopter.ui.fragments.list.all.group

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepository
import com.helicopter.data.repository.list.ListRepositoryImpl
import com.helicopter.data.repository.schedule.ScheduleRepositoryImpl
import com.helicopter.ui.fragments.schedule.ScheduleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectGroupViewModel(private val app: Application) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)

    init{
        viewModelScope.launch(Dispatchers.Main) {
            repository.refreshStudentGroupList()
            repository.refreshSpecialityList()
            repository.refreshFacultyList()
            val info = repository.fetchStudentGroupInformation()
            repository.refreshStudentGroupList()

        }
    }

    val studentGroupList = repository.fetchStudentGroupList()

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SelectGroupViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SelectGroupViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
