package com.helicopter.data

import android.app.Application
import androidx.preference.PreferenceManager

private const val SUBGROUP_KEY = "SUBGROUP"

fun fetchSubgroupNumber(app: Application): String{
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    return preference.getString(SUBGROUP_KEY, "0") ?: "0"
}

private const val GROUP_ID_KEY = "GROUP_ID"

fun fetchGroupId(app: Application): Long{
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    return preference.getLong(GROUP_ID_KEY, 0)
}

fun setGroupId(app: Application, groupNumber: Long){
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    preference.edit().apply{
        putLong(GROUP_ID_KEY, groupNumber)
        apply()
    }
}

private const val EMPLOYEE_ID_KEY = "EMPLOYEE_ID"

fun fetchEmployeeId(app: Application): Long{
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    return preference.getLong(EMPLOYEE_ID_KEY, 0)
}

fun setEmployeeId(app: Application, employeeId: Long){
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    preference.edit().apply{
        putLong(GROUP_ID_KEY, employeeId)
        apply()
    }
}

private const val GROUP_FLAG_KEY = "GROUP_FLAG"

fun fetchGroupFlag(app: Application): Boolean{
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    return preference.getBoolean(GROUP_FLAG_KEY, true)
}

fun setGroupFlag(app: Application, isGroupSchedule: Boolean){
    val preference = PreferenceManager.getDefaultSharedPreferences(app)
    preference.edit().apply{
        putBoolean(GROUP_FLAG_KEY, isGroupSchedule)
        apply()
    }
}