package com.helicopter.ui.bindingUtils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.helicopter.R
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun ImageView.setEmployeeImage(url: String?){
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_person_24dp)
        .fit()
        .into(this)
}
