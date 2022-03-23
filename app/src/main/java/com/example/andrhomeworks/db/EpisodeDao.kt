package com.example.andrhomeworks.db

import androidx.room.*
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episode")
    fun getAllEp(): Observable<List<Episode>>

    @Query("SELECT * FROM episode WHERE id = :id")
    fun getById(id: Long?): Single<Episode>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(episodes: List<Episode>)

}