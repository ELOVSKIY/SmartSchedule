package com.helicopter.ui.bindingUtils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.helicopter.R

@BindingAdapter("subgroup")
fun TextView.setSubgroupText(subgroup: Int) {
    text = when (subgroup){
        0 -> ""
        else -> context.resources.getString(R.string.subgroup_numb, subgroup)
    }
}