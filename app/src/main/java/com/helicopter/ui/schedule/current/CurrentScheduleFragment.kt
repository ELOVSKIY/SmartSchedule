package com.helicopter.ui.schedule.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R

class CurrentScheduleFragment : Fragment() {

    private lateinit var viewModel: CurrentScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_schedule_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, CurrentScheduleViewModel.Factory(activity!!.application)).get(CurrentScheduleViewModel::class.java)
        viewModel.fetchSchedule()
    }

}
