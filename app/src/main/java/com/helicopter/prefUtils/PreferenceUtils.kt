package com.helicopter.prefUtils

import android.app.Application
import android.content.Context

private const val WEEK_NUMB_PREFERENCE = "WEEK_NUMB_PREFERENCE"

private const val WEEK_NUMB_KEY = "WEEK_NUMB_KEY"
private const val WEEK_NUMB_DEFAULT = 1

fun saveWeekNumb(weekNumb: Int, app: Application){
    val preference = app.getSharedPreferences(WEEK_NUMB_PREFERENCE, Context.MODE_PRIVATE)
    with(preference.edit()){
        putInt(WEEK_NUMB_KEY, weekNumb)
        apply()
    }
}

fun fetchWeekNumb(app: Application): Int{
    val preference = app.getSharedPreferences(WEEK_NUMB_PREFERENCE, Context.MODE_PRIVATE)
    return preference.getInt(WEEK_NUMB_KEY, WEEK_NUMB_DEFAULT)
}