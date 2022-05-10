package com.example.andrhomeworks.data.repo

import com.example.andrhomeworks.data.local.CharacterDao
import com.example.andrhomeworks.data.models.CharacterDto
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.models.ResponseDto
import com.example.andrhomeworks.data.network.Api
import com.example.andrhomeworks.di.annotations.ApiWithInterceptor
import com.example.andrhomeworks.di.annotations.ApiWithoutInterceptor
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repo @Inject constructor(
    @ApiWithInterceptor
    private val apiWithInterceptor: Api,
    @ApiWithoutInterceptor
    private val apiWithoutInterceptor: Api,
    private val characterDao: CharacterDao
) {
    fun getAllCharacters(): Observable<List<CharacterDto>> {
        return apiWithInterceptor.getAllCharacters()
            .subscribeOn(Schedulers.io())
    }

    fun insertList(characterList: List<CharacterEntity>) {
        characterDao.insertList(characterList)
    }

    fun getCharacterById(id: Long): Single<CharacterEntity> {
        return apiWithoutInterceptor.getCharacterById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getCharactersAsLive() = characterDao.getAll()
}