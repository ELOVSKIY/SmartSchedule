package com.helicopter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicopter.data.network.remote.response.groupSchedulerResponse.GroupScheduleResponse
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    val scheduler = MutableLiveData<GroupScheduleResponse>()

    fun fetchSchedule(groupNumb: Int) {
        coroutineScope.launch {
            scheduler.value =
                RetrofitClient.getScheduleApi().fetchSchedulerByStudentGroup(groupNumb)
        }
    }
}