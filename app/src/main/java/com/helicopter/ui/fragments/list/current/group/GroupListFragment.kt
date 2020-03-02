package com.helicopter.ui.fragments.list.current.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

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


        val simple = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                viewModel.unSelectGroup(position)
            }
        }
        val touchHelper = ItemTouchHelper(simple)
        touchHelper.attachToRecyclerView(binding.groupRecycler)

        groupAdapter.setOnClickListener {groupId ->
            viewModel.setMainSchedule(groupId)
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
        viewModel.unSelectEvent.observe(viewLifecycleOwner, Observer {position ->
            position?.let{
                groupAdapter.notifyItemRemoved(position)
                viewModel.onUnSelect()
            }
        })
    }
}
