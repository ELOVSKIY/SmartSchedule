package com.helicopter.ui.fragments.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.databinding.ListHolderFragmentBinding
import com.helicopter.ui.adapter.pages.ListPagesAdapter
import com.helicopter.ui.fragments.ObservableFragment
import com.helicopter.ui.fragments.list.select.employee.SelectEmployeeActivity
import com.helicopter.ui.fragments.list.select.group.SelectGroupActivity
import java.lang.IllegalArgumentException

class ListHolderFragment : ObservableFragment() {

    private lateinit var viewModel: ListHolderViewModel
    private lateinit var binding: ListHolderFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListHolderViewModel::class.java)
        binding = ListHolderFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        val listPagesAdapter = ListPagesAdapter(childFragmentManager, activity!!.application)
        binding.pages.adapter = listPagesAdapter
        binding.listTabs.setupWithViewPager(binding.pages)
        return binding.root
    }

    override fun setObservers() {
        viewModel.navigateToSelect.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                viewModel.onNavigateToSelect()
                val intent = when (binding.pages.currentItem) {
                    0 -> {
                        Intent(context, SelectGroupActivity::class.java)
                    }
                    1 -> {
                        Intent(context, SelectEmployeeActivity::class.java)
                    }
                    else -> throw IllegalArgumentException()
                }
                activity?.startActivity(intent)
            }
        })
    }
}
