package com.helicopter.ui.adapter.pages

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.helicopter.R
import com.helicopter.ui.fragments.schedule.day.DayScheduleFragment
import java.lang.IllegalArgumentException
import java.util.*

class SchedulePagesAdapter(fragmentManager: FragmentManager,private val res: Resources
    ): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){




    override fun getItem(position: Int): Fragment {
        return DayScheduleFragment()
    }

    override fun getCount(): Int {
        return 30
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, position)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return "${getDayOfWeek(dayOfWeek)} ${transformDate(day)}.${transformDate(month)}"
    }

    private fun getDayOfWeek(day: Int): String{
        return when(day){
            1 -> res.getString(R.string.sunday)
            2 -> res.getString(R.string.monday)
            3 -> res.getString(R.string.tuesday)
            4 -> res.getString(R.string.wednesday)
            5 -> res.getString(R.string.thursday)
            6 -> res.getString(R.string.friday)
            7 -> res.getString(R.string.saturday)
            else -> throw IllegalArgumentException()
        }
    }

    private fun transformDate(date: Int): String{
        val strDate = date.toString()
        return if (strDate.length == 1){
            "0$date"
        }else{
            "$date"
        }
    }

}