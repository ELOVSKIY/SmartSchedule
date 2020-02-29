package com.helicopter.ui.fragments.list.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.databinding.EmployeeListFragmentBinding
import com.helicopter.ui.adapter.recycler.EmployeeAdapter

class EmployeeListFragment : Fragment() {

    private lateinit var viewModel: EmployeeListViewModel
    private lateinit var binding: EmployeeListFragmentBinding
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, EmployeeListViewModel.Factory(
            activity!!.application
        )).get(EmployeeListViewModel::class.java)

        employeeAdapter = EmployeeAdapter()
        //TODO(test)
        employeeAdapter.setOnClickListener { employeeId ->
            viewModel.unSelectEmployee(employeeId)
        }

        binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.employeeRecycler.adapter = employeeAdapter

        setObservers()
        return binding.root
    }

    private fun setObservers(){
        viewModel.employeeList.observe(viewLifecycleOwner, Observer { employeeList ->
            if (employeeList != null){
                employeeAdapter.submitList(employeeList)
            }
        })
    }

}
