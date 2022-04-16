package com.example.andrhomeworks.data.repo

import com.example.andrhomeworks.data.local.CharacterDao
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.models.ResponseDto
import com.example.andrhomeworks.data.network.Api
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class Repo(
    private val api: Api,
    private val characterDao: CharacterDao,
) {
    fun getAllCharacters(): Observable<ResponseDto> {
        return api.getAllCharacters()
            .subscribeOn(Schedulers.io())
    }

    fun insertList(characterList: List<CharacterEntity>) {
        characterDao.insertList(characterList)
    }

    fun getCharacterById(id: Long): Single<CharacterEntity> {
        return characterDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getCharactersAsLive() = characterDao.getAll()
}