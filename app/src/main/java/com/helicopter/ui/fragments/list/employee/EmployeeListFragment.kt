package com.helicopter.ui.fragments.list.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.databinding.EmployeeListFragmentBinding

class EmployeeListFragment : Fragment() {

    private lateinit var viewModel: EmployeeListViewModel
    private lateinit var binding: EmployeeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(EmployeeListViewModel::class.java)
        binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

}
