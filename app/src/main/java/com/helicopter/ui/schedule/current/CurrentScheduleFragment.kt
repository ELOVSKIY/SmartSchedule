package com.helicopter.ui.schedule.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.helicopter.R

class CurrentScheduleFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentScheduleFragment()
    }

    private lateinit var viewModel: CurrentScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_schedule_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentScheduleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
