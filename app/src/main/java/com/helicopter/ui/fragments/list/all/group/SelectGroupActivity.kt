package com.helicopter.ui.fragments.list.all.group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.helicopter.R
import com.helicopter.databinding.ActivitySelectGroupBinding
import com.helicopter.ui.adapter.recycler.GroupAdapter

class SelectGroupActivity : AppCompatActivity() {

    private lateinit var viewModel: SelectGroupViewModel
    private lateinit var binding: ActivitySelectGroupBinding
    private lateinit var groupAdapter: GroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupAdapter = GroupAdapter()
        viewModel = ViewModelProvider(this, SelectGroupViewModel.Factory(application))
            .get(SelectGroupViewModel::class.java)
        val binding: ActivitySelectGroupBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_select_group
        )
        binding.viewModel = viewModel
        binding.groupRecycler.adapter = groupAdapter
        setObservers()
    }

    private fun setObservers(){
        viewModel.studentGroupList.observe(this, Observer {groupList ->
            groupList?.let{
                groupAdapter.submitList(groupList)
            }
        })
    }
}
