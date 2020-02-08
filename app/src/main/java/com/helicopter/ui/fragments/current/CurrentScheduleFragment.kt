package com.helicopter.ui.fragments.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import kotlinx.android.synthetic.main.current_schedule_fragment.*

class CurrentScheduleFragment : Fragment() {

    private lateinit var viewModel: CurrentScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, CurrentScheduleViewModel.Factory(activity!!.application)).get(CurrentScheduleViewModel::class.java)
        return inflater.inflate(R.layout.current_schedule_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchSchedule()
        viewModel.schedule.observe(viewLifecycleOwner, Observer {
            text.text = it.size.toString()
        })
    }

}
