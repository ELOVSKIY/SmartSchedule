package com.helicopter.ui.fragments.list.all.group

import android.app.Application
import androidx.lifecycle.*
import com.helicopter.data.database.database.getInstance
import com.helicopter.data.repository.list.ListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectGroupViewModel(private val app: Application) : ViewModel() {

    private val database = getInstance(app)
    private val repository = ListRepositoryImpl(database)
    val studentGroupList = repository.fetchStudentGroupInfo()

    private val _groupSelected = MutableLiveData<Boolean>(false)
    val groupSelected: LiveData<Boolean>
    get()= _groupSelected

    init{
        viewModelScope.launch(Dispatchers.Main) {
            repository.refreshStudentGroupInfo()
        }
    }



    fun selectStudentGroup(groupId: Long){
        viewModelScope.launch(Dispatchers.Main) {
            repository.selectStudentGroup(groupId)
            _groupSelected.value = true
        }
    }

    fun onGroupSelected(){
        _groupSelected.value = false
    }

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
