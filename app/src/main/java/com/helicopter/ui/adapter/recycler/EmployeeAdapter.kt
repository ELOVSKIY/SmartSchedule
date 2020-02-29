package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.EmployeeItemBinding
import com.helicopter.databinding.GroupItemBinding
import com.helicopter.domain.models.EmployeeDomainModel
import com.helicopter.domain.models.StudentGroupDomainModel
import java.lang.IllegalArgumentException


class EmployeeAdapter : ListAdapter<EmployeeDomainModel, EmployeeViewHolder>(this) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = getItem(position)
        holder.bind(employee)
    }

    companion object : DiffUtil.ItemCallback<EmployeeDomainModel>() {
        override fun areItemsTheSame(
            oldItem: EmployeeDomainModel, newItem: EmployeeDomainModel
        ): Boolean {
            return oldItem.employeeId == newItem.employeeId
        }

        override fun areContentsTheSame(
            oldItem: EmployeeDomainModel, newItem: EmployeeDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class EmployeeViewHolder(private val binding: EmployeeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(employee: EmployeeDomainModel) {
        binding.employee = employee
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): EmployeeViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = EmployeeItemBinding.inflate(inflater, parent, false)
            return EmployeeViewHolder(binding)
        }
    }
}



