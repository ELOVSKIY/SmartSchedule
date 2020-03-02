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