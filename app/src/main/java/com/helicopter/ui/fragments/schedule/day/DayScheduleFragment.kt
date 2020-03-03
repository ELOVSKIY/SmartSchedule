package com.helicopter.ui.fragments.schedule.day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.helicopter.R
import com.helicopter.databinding.DayScheduleFragmentBinding
import com.helicopter.ui.adapter.recycler.ScheduleAdapter
import com.helicopter.ui.fragments.ObservableFragment


class DayScheduleFragment : ObservableFragment() {

    private lateinit var viewModel: DayScheduleViewModel
    private val adapter = ScheduleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            this, DayScheduleViewModel.Factory(
                activity!!.application
            )
        )[DayScheduleViewModel::class.java]
        val binding = DayScheduleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setObservers() {
        viewModel.schedule.observe(viewLifecycleOwner, Observer { scheduleList ->
            scheduleList?.let {
                adapter.submitList(scheduleList)
            }
        })
    }
}
