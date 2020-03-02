package com.helicopter.ui.fragments.list.current.employee

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeListViewModel(app: Application) : ViewModel() {
    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)
    val employeeList = repository.fetchSelectedEmployeeList()

    fun unSelectEmployee(employeeId: Long){
        viewModelScope.launch(Dispatchers.Main){
            repository.unSelectEmployee(employeeId)
        }
    }


    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmployeeListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
