package com.example.andrhomeworks.db

import androidx.room.TypeConverter
import com.google.gson.Gson

class TypeListConverter {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun locationToJson(value: Location?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String) = Gson().fromJson(value, Location::class.java)
}