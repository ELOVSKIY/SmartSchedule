package com.helicopter.ui.adapter.pages

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.helicopter.R
import com.helicopter.ui.fragments.list.current.employee.EmployeeListFragment
import com.helicopter.ui.fragments.list.current.group.GroupListFragment
import java.lang.IllegalArgumentException

class ListPagesAdapter(fragmentManager: FragmentManager, private val app: Application
    ): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> GroupListFragment()
            1 -> EmployeeListFragment()
            else -> throw IllegalArgumentException()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> app.getString(R.string.groups)
            1 -> app.getString(R.string.employee)
            else -> throw IllegalArgumentException()
        }
    }
}