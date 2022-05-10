package com.example.andrhomeworks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.andrhomeworks.data.models.CharacterEntity

@TypeConverters(TypeListConverter::class)
@Database(entities = [CharacterEntity::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}