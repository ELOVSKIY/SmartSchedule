package com.helicopter.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.helicopter.databinding.ListHolderFragmentBinding
import com.helicopter.ui.adapter.pages.ListPagesAdapter

class ListHolderFragment : Fragment() {

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

}
