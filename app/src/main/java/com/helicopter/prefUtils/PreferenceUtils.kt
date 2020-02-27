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


private const val LAST_UPDATE_TIME_PREFERENCE = "LAST_UPDATE_TIME_PREFERENCE"
private const val LAST_UPDATE_TIME_KEY = "LAST_UPDATE_TIME"
private const val LAST_UPDATE_TIME_DEFAULT = 0

fun saveLastUpdateTime(lastUpdateTime: Int, app: Application){
    val preference = app.getSharedPreferences(LAST_UPDATE_TIME_PREFERENCE, Context.MODE_PRIVATE)
    with(preference.edit()){
        putInt(LAST_UPDATE_TIME_KEY, lastUpdateTime)
        apply()
    }
}

fun fetchLastUpdateTime(app: Application): Int{
    val preference = app.getSharedPreferences(LAST_UPDATE_TIME_PREFERENCE, Context.MODE_PRIVATE)
    return preference.getInt(LAST_UPDATE_TIME_KEY, LAST_UPDATE_TIME_DEFAULT)
}