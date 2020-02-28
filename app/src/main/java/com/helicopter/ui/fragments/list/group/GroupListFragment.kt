package com.helicopter.ui.fragments.list.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.R
import com.helicopter.databinding.GroupListFragmentBinding

class GroupListFragment : Fragment() {

    private lateinit var viewModel: GroupListViewModel
    private lateinit var binding: GroupListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GroupListViewModel::class.java)
        binding = GroupListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }
}
