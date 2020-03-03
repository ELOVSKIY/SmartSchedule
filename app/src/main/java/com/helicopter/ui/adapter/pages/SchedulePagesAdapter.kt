package com.helicopter.ui.adapter.pages

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.helicopter.R
import com.helicopter.ui.fragments.schedule.day.DayScheduleFragment
import java.lang.IllegalArgumentException
import java.util.*

private const val DAY_COUNT = 30

class SchedulePagesAdapter(
    fragmentManager: FragmentManager, private val app: Application
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putInt(DayScheduleFragment.OFFSET, position)
        return DayScheduleFragment().apply {
            this.arguments = args
        }
    }

    override fun getCount(): Int {
        return DAY_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, position)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return "${getDayOfWeekTitle(dayOfWeek)} ${transformDate(day)}.${transformDate(month)}"
    }

    private fun getDayOfWeekTitle(day: Int): String {
        return when (day) {
            1 -> app.getString(R.string.sunday)
            2 -> app.getString(R.string.monday)
            3 -> app.getString(R.string.tuesday)
            4 -> app.getString(R.string.wednesday)
            5 -> app.getString(R.string.thursday)
            6 -> app.getString(R.string.friday)
            7 -> app.getString(R.string.saturday)
            else -> throw IllegalArgumentException()
        }
    }

    private fun transformDate(date: Int): String {
        val strDate = date.toString()
        return if (strDate.length == 1) {
            "0$date"
        } else {
            "$date"
        }
    }
}