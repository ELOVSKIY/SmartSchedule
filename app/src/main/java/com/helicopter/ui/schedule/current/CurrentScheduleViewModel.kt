package com.helicopter.ui.schedule.current

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CurrentScheduleViewModel : ViewModel() {
    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    val scheduler = MutableLiveData<Any>()

    fun fetchSchedule() {
        coroutineScope.launch {
            val t = RetrofitClient.getScheduleApi().fetchEployeeScheduleById(500434)
            val r = RetrofitClient.getListApi().fetchGroupList()

        }
    }
}
