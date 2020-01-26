package com.helicopter.data.database.entities.convertors

import androidx.room.TypeConverter
import java.util.stream.Collectors


class ListConverter{
    @TypeConverter
    fun stringListToString(list: List<String>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun stringToStringList(data: String): List<String?>? {
        return data.split(",")
    }

    @TypeConverter
    fun intListToString(list: List<Int>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun stringToIntList(data: String): List<Int?>? {
        return data.split(",").map{it.toInt()}
    }
}