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


class GroupScheduleViewHolder(private val binding: GroupScheduleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(schedule: ScheduleDomainModel) {
        binding.schedule = schedule
    }

    companion object {
        fun from(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = GroupScheduleItemBinding.inflate(inflater, parent, false)
            return GroupScheduleViewHolder(
                binding
            )
        }
    }
}

class GroupScheduleWithoutEmployeeViewHolder(private val binding: GroupScheduleWithoutEmployeeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(schedule: ScheduleDomainModel) {
        binding.schedule = schedule
    }

    companion object {
        fun from(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = GroupScheduleWithoutEmployeeItemBinding.inflate(inflater, parent, false)
            return GroupScheduleWithoutEmployeeViewHolder(
                binding
            )
        }
    }
}


class EmployeeScheduleViewHolder(private val binding: EmployeeScheduleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(schedule: ScheduleDomainModel) {
        binding.schedule = schedule
    }

    companion object {
        fun from(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = EmployeeScheduleItemBinding.inflate(inflater, parent, false)
            return EmployeeScheduleViewHolder(
                binding
            )
        }
    }
}

