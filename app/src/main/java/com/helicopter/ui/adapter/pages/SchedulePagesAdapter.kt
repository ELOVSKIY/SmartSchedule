package com.helicopter.ui.adapter.pages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.helicopter.ui.fragments.schedule.day.DayScheduleFragment
import java.util.*

class SchedulePagesAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        return DayScheduleFragment()
    }

    override fun getCount(): Int {
        return 30
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, position)
        return calendar.time.day.toString()
    }
}