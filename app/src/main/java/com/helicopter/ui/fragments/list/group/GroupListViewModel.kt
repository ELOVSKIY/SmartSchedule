package com.helicopter.ui.fragments.list.group

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupListViewModel(app: Application) : ViewModel() {
    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)
    val studentGroupList = repository.fetchSelectedGroupInfo()

    fun unSelectGroup(groupId: Long){
        viewModelScope.launch(Dispatchers.Main){
            repository.unSelectStudentGroup(groupId)
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
