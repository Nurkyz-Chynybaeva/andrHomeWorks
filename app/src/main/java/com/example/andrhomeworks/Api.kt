package com.example.andrhomeworks

import com.example.andrhomeworks.db.CharacterEntity
import com.example.andrhomeworks.db.Response
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("character")
    fun getAllCharacters(): Observable<Response>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Long): Single<CharacterEntity>

}