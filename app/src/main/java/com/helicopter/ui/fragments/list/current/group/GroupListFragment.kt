package com.helicopter.ui.fragments.list.current.group

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.R

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
        viewModel = ViewModelProvider(
            this, GroupListViewModel.Factory(
                activity!!.application
            )
        ).get(GroupListViewModel::class.java)
        binding = GroupListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        groupAdapter.setOnClickListener { groupId ->
            viewModel.setMainSchedule(groupId)
        }
        groupAdapter.setOnLongClickListener { groupId ->
            AlertDialog.Builder(context).apply {
                setMessage(getString(R.string.do_you_want_remove_item))
                setPositiveButton(getString(R.string.accept)){ _, _ -> viewModel.unSelectGroup(groupId)}
                setNegativeButton(getString(R.string.reject)){ _, _ -> }
                setCancelable(true)
                create()
                show()
            }
        }

        binding.groupRecycler.adapter = groupAdapter
        return binding.root
    }

    override fun setObservers() {
        viewModel.studentGroupList.observe(viewLifecycleOwner, Observer { studentGroupList ->
            if (studentGroupList != null) {
                groupAdapter.submitList(studentGroupList)
            }
        })
    }

}
