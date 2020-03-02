package com.helicopter.ui.fragments.list.select.group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
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
        groupAdapter.setOnClickListener { groupId ->
            viewModel.selectStudentGroup(groupId)
        }
        binding.viewModel = viewModel
        binding.groupRecycler.adapter = groupAdapter


        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        setObservers()
    }

    private fun setObservers() {
        viewModel.studentGroupList.observe(this, Observer { groupList ->
            groupList?.let {
                groupAdapter.submitList(groupList)
            }
        })
        viewModel.groupSelected.observe(this, Observer { selected ->
            if (selected) {
                viewModel.onGroupSelected()
                finish()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        if (menu != null) {
            val searchView = menu.findItem(R.id.action_search).actionView as SearchView
            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    groupAdapter.search(newText)
                    return false
                }
            })
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
