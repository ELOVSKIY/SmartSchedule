package com.helicopter.ui.fragments.list.all.employee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.helicopter.R
import com.helicopter.databinding.ActivitySelectEmployeeBinding
import com.helicopter.ui.adapter.recycler.EmployeeAdapter

class SelectEmployeeActivity : AppCompatActivity() {

    private lateinit var viewModel: SelectEmployeeViewModel
    private lateinit var binding: ActivitySelectEmployeeBinding
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_select_employee
        )
        employeeAdapter = EmployeeAdapter()
        viewModel = ViewModelProvider(this, SelectEmployeeViewModel.Factory(application))
            .get(SelectEmployeeViewModel::class.java)
        binding.viewModel = viewModel
        binding.employeeRecycler.adapter = employeeAdapter

        setObservers()
    }

    private fun setObservers() {
        viewModel.employeeList.observe(this, Observer {employeeList ->
            employeeList?.let{
                employeeAdapter.submitList(it)
            }
        })
    }
}
