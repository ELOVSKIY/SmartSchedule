package com.helicopter.ui.fragments.list.current.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.helicopter.databinding.GroupListFragmentBinding
import com.helicopter.ui.adapter.recycler.GroupAdapter
import com.helicopter.ui.fragments.ObservableFragment

class GroupListFragment : ObservableFragment() {

    private lateinit var viewModel: GroupListViewModel
    private lateinit var binding: GroupListFragmentBinding
    private lateinit var groupAdapter: GroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupAdapter = GroupAdapter()
        viewModel = ViewModelProvider(this, GroupListViewModel.Factory(
            activity!!.application
        )).get(GroupListViewModel::class.java)
        binding = GroupListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        //TODO (тестовое)
        groupAdapter.setOnClickListener {
            viewModel.unSelectGroup(it)
        }

        binding.groupRecycler.adapter = groupAdapter
        return binding.root
    }

    override fun setObservers() {
        viewModel.studentGroupList.observe(viewLifecycleOwner, Observer {studentGroupList ->
            if (studentGroupList != null){
                groupAdapter.submitList(studentGroupList)
            }
        })
    }
}
