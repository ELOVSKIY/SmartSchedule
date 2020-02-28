package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.GroupItemBinding
import com.helicopter.domain.models.StudentGroupDomainModel
import java.lang.IllegalArgumentException


class GroupAdapter : ListAdapter<StudentGroupDomainModel, StudentGroupViewHolder>(this) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentGroupViewHolder {
        return StudentGroupViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentGroupViewHolder, position: Int) {
        val studentGroup = getItem(position)
        holder.bind(studentGroup)
    }

    companion object : DiffUtil.ItemCallback<StudentGroupDomainModel>() {
        override fun areItemsTheSame(
            oldItem: StudentGroupDomainModel, newItem: StudentGroupDomainModel
        ): Boolean {
            return oldItem.groupId == newItem.groupId
        }

        override fun areContentsTheSame(
            oldItem: StudentGroupDomainModel, newItem: StudentGroupDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class StudentGroupViewHolder(private val binding: GroupItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(studentGroup: StudentGroupDomainModel) {
        binding.studentGroup = studentGroup
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): StudentGroupViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = GroupItemBinding.inflate(inflater, parent, false)
            return StudentGroupViewHolder(binding)
        }
    }
}



