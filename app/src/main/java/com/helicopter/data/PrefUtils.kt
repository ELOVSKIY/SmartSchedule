package com.helicopter.data

import android.app.Application
import androidx.preference.PreferenceManager

private const val SUBGROUP_KEY = "SUBGROUP"

fun fetchSubgroupNumber(app: Application): String{
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    return preference.getString(SUBGROUP_KEY, "0") ?: "0"
}