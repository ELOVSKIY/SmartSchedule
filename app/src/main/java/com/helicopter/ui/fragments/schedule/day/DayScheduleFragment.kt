package com.helicopter.ui.fragments.schedule.day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.helicopter.R
import com.helicopter.databinding.DayScheduleFragmentBinding


class DayScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DayScheduleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
