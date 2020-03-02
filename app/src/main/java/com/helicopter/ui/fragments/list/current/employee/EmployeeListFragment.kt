package com.helicopter.ui.fragments.list.current.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

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
        employeeAdapter = EmployeeAdapter()
        viewModel = ViewModelProvider(this, EmployeeListViewModel.Factory(
            activity!!.application
        )).get(EmployeeListViewModel::class.java)
        binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        employeeAdapter.apply {
            setOnClickListener { employeeId ->
                viewModel.setMainSchedule(employeeId)
            }
            setOnLongClickListener { employeeId->
                viewModel.unSelectEmployee(employeeId)
            }
        }

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
