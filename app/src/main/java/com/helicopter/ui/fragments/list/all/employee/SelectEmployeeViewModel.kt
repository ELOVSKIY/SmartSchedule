package com.helicopter.ui.fragments.list.all.employee

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectEmployeeViewModel(private val app: Application) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)

    init {
        viewModelScope.launch(Dispatchers.Main) {
            repository.refreshEmployeeList()
        }
    }

    val employeeList = repository.fetchEmployeeList()

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SelectEmployeeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SelectEmployeeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
