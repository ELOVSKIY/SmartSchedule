package com.helicopter.ui.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListHolderViewModel : ViewModel() {

    private val _navigateToSelect = MutableLiveData<Boolean>()
    val navigateToSelect: LiveData<Boolean>
        get() = _navigateToSelect

    fun onFabClick(){
        _navigateToSelect.value = true
    }

    fun onNavigateToSelect(){
        _navigateToSelect.value = false
    }
}
