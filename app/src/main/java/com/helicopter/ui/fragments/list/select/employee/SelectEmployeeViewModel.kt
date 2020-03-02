package com.helicopter.ui.fragments.list.select.employee

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectEmployeeViewModel(app: Application) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)

    val employeeList = repository.fetchEmployeeList()

    private val _employeeSelected = MutableLiveData(false)
    val employeeSelected: LiveData<Boolean>
        get() = _employeeSelected

    init {
        viewModelScope.launch(Dispatchers.Main) {
            repository.refreshEmployeeList()
        }
    }

    fun selectEmployee(employeeId: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.selectEmployee(employeeId)
            _employeeSelected.value = true
        }
    }

    fun onEmployeeSelected(){
        _employeeSelected.value = false
    }


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
