package com.helicopter.ui.adapter.recycler.viewholders.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.EmployeeScheduleItemBinding
import com.helicopter.databinding.GroupScheduleItemBinding
import com.helicopter.databinding.GroupScheduleWithoutEmployeeItemBinding
import com.helicopter.domain.models.ScheduleDomainModel

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