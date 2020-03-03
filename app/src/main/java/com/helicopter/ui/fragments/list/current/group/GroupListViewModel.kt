package com.helicopter.ui.fragments.list.current.group

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupListViewModel(app: Application) : ViewModel() {
    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)
    val studentGroupList = repository.fetchSelectedGroupInfo()

    fun unSelectGroup(groupId: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.unSelectStudentGroup(groupId)
        }
    }

    fun setMainSchedule(groupId: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.setMainStudentGroupSchedule(groupId)
        }
    }


    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GroupListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GroupListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}