package com.example.moviesapp.database

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListToString(list: List<Int>?): String? {
        val sb = StringBuilder()
        if (list.isNullOrEmpty()) return null

        list.forEach {
            sb.append(",")
            sb.append(it)
        }
        return sb.reverse().toString()
    }

    @TypeConverter
    fun fromStringToList(str: String?): List<Int> {
        return if (!str.isNullOrEmpty()) {
            str.split(",").map { it.toInt() }
        } else emptyList()
    }
}