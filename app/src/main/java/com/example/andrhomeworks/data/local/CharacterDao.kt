package com.example.andrhomeworks.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.andrhomeworks.data.models.CharacterEntity
import io.reactivex.Single

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characterentity")
    fun getAll(): LiveData<List<CharacterEntity>>

    @Query("SELECT * FROM characterentity WHERE id = :id")
    fun getById(id: Long?): Single<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characterList: List<CharacterEntity>)

    @Query("DELETE from CharacterEntity")
    fun deleteAll()
}