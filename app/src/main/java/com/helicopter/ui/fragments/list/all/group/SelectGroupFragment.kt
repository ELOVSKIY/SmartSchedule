package com.helicopter.ui.fragments.list.all.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.databinding.SelectGroupFragmentBinding
import com.helicopter.ui.adapter.recycler.GroupAdapter
import com.helicopter.ui.fragments.ObservableFragment

class SelectGroupFragment : ObservableFragment() {

    private lateinit var viewModel: SelectGroupViewModel
    private lateinit var binding: SelectGroupFragmentBinding
    private lateinit var groupAdapter: GroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SelectGroupViewModel::class.java)
        groupAdapter = GroupAdapter()
        val binding = SelectGroupFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.groupRecycler.adapter = groupAdapter
        return binding.root
    }

}
