package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.GroupItemBinding
import com.helicopter.domain.models.StudentGroupInfoDomainModel


class GroupAdapter : ListAdapter<StudentGroupInfoDomainModel, StudentGroupViewHolder>(this) {

    private var listener: (groupId: Long) -> Unit = {}

    fun setOnClickListener(listener: (groupId: Long) -> Unit){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentGroupViewHolder {
        return StudentGroupViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentGroupViewHolder, position: Int) {
        val studentGroup = getItem(position)
        holder.bind(studentGroup, listener)
    }

    companion object : DiffUtil.ItemCallback<StudentGroupInfoDomainModel>() {
        override fun areItemsTheSame(
            oldItem: StudentGroupInfoDomainModel, newItem: StudentGroupInfoDomainModel
        ): Boolean {
            return oldItem.studentGroup.groupId == newItem.studentGroup.groupId
        }

        override fun areContentsTheSame(
            oldItem: StudentGroupInfoDomainModel, newItem: StudentGroupInfoDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class StudentGroupViewHolder(private val binding: GroupItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(studentGroup: StudentGroupInfoDomainModel, onClickListener: (groupId: Long) -> Unit) {
        binding.studentGroupInfo = studentGroup
        binding.root.setOnClickListener {
            onClickListener(studentGroup.studentGroup.groupId)
        }
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



