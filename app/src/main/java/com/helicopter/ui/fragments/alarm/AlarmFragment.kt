package com.helicopter.ui.fragments.alarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.databinding.AlarmFragmentBinding

class AlarmFragment : Fragment() {

    private lateinit var viewModel: AlarmViewModel
    private lateinit var binding: AlarmFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AlarmFragmentBinding.inflate(inflater, container, false)
        binding.timePicker.setIs24HourView(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
