package com.example.andrhomeworks.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CharacterDao {

    @androidx.room.Query("SELECT * FROM CharacterEntity")
    fun getAll(): LiveData<List<CharacterEntity>>

    @androidx.room.Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getById(id: Long?): CharacterEntity

//    @Insert
//    fun insert(character: CharacterEntity): Long
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertList(characters: List<CharacterEntity>)
//
//
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(characterList: List<CharacterEntity>)

//    @Update
//    fun update(character: CharacterEntity)
//
//    @Delete
//    fun delete(character: CharacterEntity)
//
//    @androidx.room.Query("DELETE from CharacterEntity")
//    fun deleteAll()
}