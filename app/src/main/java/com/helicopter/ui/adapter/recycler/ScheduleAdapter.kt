package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.EmployeeScheduleItemBinding
import com.helicopter.databinding.GroupScheduleItemBinding
import com.helicopter.domain.models.ScheduleDomainModel
import java.lang.IllegalArgumentException

private const val GROUP_SCHEDULE = 0
private const val EMPLOYEE_SCHEDULE = 1


class ScheduleAdapter: ListAdapter<ScheduleDomainModel, RecyclerView.ViewHolder>(this) {
    override fun getItemViewType(position: Int): Int {
        val schedule = getItem(position)
        return if (schedule.isGroupSchedule) GROUP_SCHEDULE else EMPLOYEE_SCHEDULE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            GROUP_SCHEDULE -> {
                GroupScheduleViewHolder.from(
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
        if (holder is GroupScheduleViewHolder){
            holder.bind(schedule)
        }
        if (holder is EmployeeScheduleViewHolder){
            holder.bind(schedule)
        }
    }

    companion object: DiffUtil.ItemCallback<ScheduleDomainModel>(){
        override fun areItemsTheSame(
            oldItem: ScheduleDomainModel, newItem: ScheduleDomainModel): Boolean {
            return (newItem.groupId == oldItem.groupId) && (oldItem.employeeId == newItem.employeeId)
                    && (oldItem.weekNumber == newItem.weekNumber) && (oldItem.lessonTime == newItem.lessonTime)
                    && (oldItem.weekDay == newItem.weekDay) && (newItem.numSubgroup == oldItem.numSubgroup)
        }

        override fun areContentsTheSame(
            oldItem: ScheduleDomainModel, newItem: ScheduleDomainModel): Boolean {
            return oldItem == newItem
        }
    }
}

class GroupScheduleViewHolder(private val binding: GroupScheduleItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(schedule: ScheduleDomainModel){
        binding.schedule = schedule
    }

    companion object{
        fun from(parent: ViewGroup): RecyclerView.ViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = GroupScheduleItemBinding.inflate(inflater, parent, false)
            return GroupScheduleViewHolder(
                binding
            )
        }
    }
}

class EmployeeScheduleViewHolder(private val binding: EmployeeScheduleItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(schedule: ScheduleDomainModel){
        binding.schedule = schedule
    }

    companion object{
        fun from(parent: ViewGroup): RecyclerView.ViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = EmployeeScheduleItemBinding.inflate(inflater, parent, false)
            return EmployeeScheduleViewHolder(
                binding
            )
        }
    }
}

