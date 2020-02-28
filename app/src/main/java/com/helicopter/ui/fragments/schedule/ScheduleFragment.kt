package com.helicopter.ui.fragments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.databinding.ScheduleFragmentBinding
import com.helicopter.ui.adapter.pages.SchedulePagesAdapter
import com.helicopter.ui.fragments.ObservableFragment

class ScheduleFragment : ObservableFragment() {

    private lateinit var viewModel: ScheduleViewModel
    private lateinit var binding: ScheduleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, ScheduleViewModel.Factory(activity!!.application)).get(ScheduleViewModel::class.java)
        binding = ScheduleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        viewLifecycleOwner.lifecycle.addObserver(viewModel)

        val schedulePagesAdapter = SchedulePagesAdapter(activity!!.supportFragmentManager, activity!!.application)
        binding.pages.adapter = schedulePagesAdapter
        binding.tabs.setupWithViewPager(binding.pages)


        return binding.root
    }

    override fun setObservers() {
        viewModel.schedule.observe(viewLifecycleOwner, Observer {

        })
    }
}
