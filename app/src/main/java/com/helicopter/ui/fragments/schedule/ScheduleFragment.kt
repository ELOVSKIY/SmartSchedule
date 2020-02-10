package com.helicopter.ui.fragments.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.databinding.ScheduleFragmentBinding
import com.helicopter.ui.adapter.pages.SchedulePagesAdapter
import kotlinx.android.synthetic.main.schedule_fragment.*

class ScheduleFragment : Fragment() {

    private lateinit var viewModel: ScheduleViewModel
    private lateinit var binding: ScheduleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, ScheduleViewModel.Factory(activity!!.application)).get(ScheduleViewModel::class.java)
        binding = ScheduleFragmentBinding.inflate(inflater, container, false)

        val schedulePagesAdapter = SchedulePagesAdapter(activity!!.supportFragmentManager, resources)
        binding.pages.adapter = schedulePagesAdapter
        binding.tabs.setupWithViewPager(binding.pages)

        return binding.root
    }

}
