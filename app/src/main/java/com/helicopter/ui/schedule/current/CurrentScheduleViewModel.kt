package com.helicopter.ui.schedule.current

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicopter.data.database.getInstance
import com.helicopter.data.network.remote.toScheduleModelEntityList
import com.helicopter.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CurrentScheduleViewModel : ViewModel() {
    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    val scheduler = MutableLiveData<Any>()

    fun fetchSchedule(context: Context) {
        coroutineScope.launch {
            try {
               val gr = RetrofitClient.getListApi().fetchGroupList()

            } catch (e: Exception) {
                Log.e("hui", e.toString())
            }

        }
    }
}
