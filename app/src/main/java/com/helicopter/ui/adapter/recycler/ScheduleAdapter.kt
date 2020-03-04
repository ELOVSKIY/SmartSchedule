package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.EmployeeScheduleItemBinding
import com.helicopter.databinding.GroupScheduleItemBinding
import com.helicopter.databinding.GroupScheduleWithoutEmployeeItemBinding
import com.helicopter.domain.models.ScheduleDomainModel
import com.helicopter.ui.adapter.recycler.viewholders.schedule.EmployeeScheduleViewHolder
import com.helicopter.ui.adapter.recycler.viewholders.schedule.GroupScheduleViewHolder
import com.helicopter.ui.adapter.recycler.viewholders.schedule.GroupScheduleWithoutEmployeeViewHolder
import java.lang.IllegalArgumentException

private const val GROUP_SCHEDULE = 0
private const val GROUP_SCHEDULE_WITHOUT_EMPLOYEE = 1
private const val EMPLOYEE_SCHEDULE = 2


class ScheduleAdapter : ListAdapter<ScheduleDomainModel, RecyclerView.ViewHolder>(this) {
    override fun getItemViewType(position: Int): Int {
        val schedule = getItem(position)
        return if (schedule.groupId != 0L) {
            if (schedule.employee != null) {
                GROUP_SCHEDULE
            }else{
                GROUP_SCHEDULE_WITHOUT_EMPLOYEE
            }
        } else {
            EMPLOYEE_SCHEDULE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            GROUP_SCHEDULE -> {
                GroupScheduleViewHolder.from(
                    parent
                )
            }
            GROUP_SCHEDULE_WITHOUT_EMPLOYEE -> {
                GroupScheduleWithoutEmployeeViewHolder.from(
                    parent
                )
            }
            EMPLOYEE_SCHEDULE -> {
                EmployeeScheduleViewHolder.from(
                    parent
                )
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val schedule = getItem(position)
        if (holder is GroupScheduleViewHolder) {
            holder.bind(schedule)
        }
        if (holder is GroupScheduleWithoutEmployeeViewHolder) {
            holder.bind(schedule)
        }
        if (holder is EmployeeScheduleViewHolder) {
            holder.bind(schedule)
        }
    }

    companion object : DiffUtil.ItemCallback<ScheduleDomainModel>() {
        override fun areItemsTheSame(
            oldItem: ScheduleDomainModel, newItem: ScheduleDomainModel
        ): Boolean {
            return (newItem.groupId == oldItem.groupId) && (oldItem.employeeId == newItem.employeeId)
                    && (oldItem.weekNumber == newItem.weekNumber) && (oldItem.lessonTime == newItem.lessonTime)
                    && (oldItem.weekDay == newItem.weekDay) && (newItem.numSubgroup == oldItem.numSubgroup)
        }

        override fun areContentsTheSame(
            oldItem: ScheduleDomainModel, newItem: ScheduleDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}




