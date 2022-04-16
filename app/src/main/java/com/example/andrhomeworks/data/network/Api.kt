package com.example.andrhomeworks.data.network

import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.models.ResponseDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("character")
    fun getAllCharacters(): Observable<ResponseDto>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Long): Single<CharacterEntity>
}