package com.helicopter.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.helicopter.R

import com.helicopter.databinding.ListHolderFragmentBinding
import com.helicopter.ui.adapter.pages.ListPagesAdapter
import com.helicopter.ui.fragments.ObservableFragment

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
        viewModel.navigateToSelect.observe(viewLifecycleOwner, Observer{
            viewModel.onNavigateToSelect()
            val navController = view!!.findNavController()
            when (binding.pages.currentItem){
                0 -> {
                    navController.navigate(R.id.action_ListHolderFragment_to_SelectGroupFragment)
                }
                1 ->{
                    navController.navigate(R.id.action_ListHolderFragment_to_SelectEmployeeFragment)
                }
            }
        })
    }
}
