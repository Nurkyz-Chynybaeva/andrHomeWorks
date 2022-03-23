package com.example.andrhomeworks

import androidx.lifecycle.LiveData
import com.example.andrhomeworks.db.Episode
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SeriesApi {

    @GET("episodes")
    fun getEpisodes(): LiveData<List<Episode>>

    @GET("episodes/{id}")
    fun getEpisodeById(@Path("id") id: Long): Single<List<Episode>>
}