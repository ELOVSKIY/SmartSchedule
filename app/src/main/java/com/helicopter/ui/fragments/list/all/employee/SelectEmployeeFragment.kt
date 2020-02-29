package com.helicopter.ui.fragments.list.all.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.data.database.entities.EmployeeEntity
import com.helicopter.databinding.SelectEmployeeFragmentBinding
import com.helicopter.ui.adapter.recycler.EmployeeAdapter
import com.helicopter.ui.fragments.ObservableFragment

class SelectEmployeeFragment : ObservableFragment() {

    private lateinit var viewModel: SelectEmployeeViewModel
    private lateinit var binding: SelectEmployeeFragmentBinding
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        employeeAdapter = EmployeeAdapter()
        viewModel = ViewModelProvider(this, SelectEmployeeViewModel.Factory(activity!!.application))
            .get(SelectEmployeeViewModel::class.java)
        binding = SelectEmployeeFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.employeeRecycler.adapter = employeeAdapter
        return binding.root
    }

    override fun setObservers() {
        viewModel.employeeList.observe(viewLifecycleOwner, Observer {employeeList ->
            employeeList?.let{
                employeeAdapter.submitList(it)
            }
        })
    }
}
