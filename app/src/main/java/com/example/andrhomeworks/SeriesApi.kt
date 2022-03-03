package com.example.andrhomeworks

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SeriesApi {

    @GET("character")
    fun getEpisode(): Observable<Response>

//    @GET("episodes/{id}")
//    fun getEpisodeById(@Path("id") id: Long): Single<Response>
}