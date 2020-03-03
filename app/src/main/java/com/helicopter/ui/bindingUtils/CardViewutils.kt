package com.helicopter.ui.bindingUtils

import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.helicopter.R

@BindingAdapter("isSelected")
fun CardView.setSelectedStatus(isSelected: Boolean) {
    this.background.setTint(
        if (isSelected) ContextCompat.getColor(context, R.color.selectedColor)
        else ContextCompat.getColor(context, R.color.unselectedColor)
    )
}

@BindingAdapter("type")
fun CardView.setSubjectType(subjectType: String) {
    this.background.setTint(
        when(subjectType){
            "ЛК" -> ContextCompat.getColor(context, R.color.lectureColor)
            "ПЗ" -> ContextCompat.getColor(context, R.color.practiceColor)
            "ЛР" -> ContextCompat.getColor(context, R.color.laboratoryColor)
            else -> ContextCompat.getColor(context, R.color.unselectedColor)
        }
    )
}