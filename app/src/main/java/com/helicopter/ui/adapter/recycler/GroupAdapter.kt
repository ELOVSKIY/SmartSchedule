package com.helicopter.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helicopter.databinding.GroupItemBinding
import com.helicopter.domain.models.StudentGroupInfoDomainModel


class GroupAdapter : ListAdapter<StudentGroupInfoDomainModel, StudentGroupViewHolder>(this) {

    private var onClickListener: (groupId: Long) -> Unit = {}
    private var onLongClickListener: (groupId: Long) -> Unit = {}

    private var searchWord = ""

    fun search(searchWord: String?) {
        this.searchWord = searchWord ?: ""
        super.submitList(list)
    }

    private var _list = mutableListOf<StudentGroupInfoDomainModel>()
    private val list: List<StudentGroupInfoDomainModel>
        get() {
            return _list.filter {
                containsSearchQuery(searchWord, it.studentGroup.name, it.speciality?.name,
                    it.speciality?.abbrev, it.faculty?.abbrev)
            }
        }


    override fun submitList(list: List<StudentGroupInfoDomainModel>?) {
        if (list != null) {
            _list.clear()
            _list.addAll(list)
            search(searchWord)
        }
    }

    fun setOnClickListener(listener: (groupId: Long) -> Unit) {
        this.onClickListener = listener
    }

    fun setOnLongClickListener(listener: (groupId: Long) -> Unit) {
        this.onLongClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentGroupViewHolder {
        return StudentGroupViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentGroupViewHolder, position: Int) {
        val studentGroup = getItem(position)
        holder.bind(studentGroup, onClickListener, onLongClickListener)
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
    fun bind(studentGroup: StudentGroupInfoDomainModel, onClickListener: (groupId: Long) -> Unit,
             onLongClickListener: (groupId: Long) -> Unit) {
        binding.studentGroupInfo = studentGroup
        binding.root.setOnClickListener {
            onClickListener(studentGroup.studentGroup.groupId)
        }
        binding.root.setOnLongClickListener {
            onLongClickListener(studentGroup.studentGroup.groupId)
            true
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



