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
import com.helicopter.generated.callback.OnClickListener
import java.lang.IllegalArgumentException


class EmployeeAdapter : ListAdapter<EmployeeDomainModel, EmployeeViewHolder>(this) {

    private var onClickListener: (employeeId: Long) -> Unit = {}

    private var searchWord = ""

    fun search(searchWord: String?) {
        this.searchWord = searchWord ?: ""
        super.submitList(list)
    }

    private var _list = mutableListOf<EmployeeDomainModel>()
    private val list: List<EmployeeDomainModel>
        get() {
            return _list.filter {
                containsSearchQuery(searchWord, it.lastName)
            }
        }

    fun setOnClickListener(listener: (employeeId: Long) -> Unit) {
        this.onClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = getItem(position)
        holder.bind(employee, onClickListener)
    }

    override fun submitList(list: List<EmployeeDomainModel>?) {
        if (list != null) {
            _list.clear()
            _list.addAll(list)
            search(searchWord)
        }
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
    fun bind(employee: EmployeeDomainModel, onClickListener:  (employeeId: Long) -> Unit) {
        binding.employee = employee
        binding.root.setOnClickListener {
            onClickListener(employee.employeeId)
        }
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



