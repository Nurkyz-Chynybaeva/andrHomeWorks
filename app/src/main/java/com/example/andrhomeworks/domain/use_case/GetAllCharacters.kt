package com.example.andrhomeworks.domain.use_case

import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.repo.Repo
import com.example.andrhomeworks.extensions.toCharacterEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class GetAllCharacters(
    private val repo: Repo
) {
    operator fun invoke(): Observable<Unit> {
        return repo.getAllCharacters().map {
            Thread.sleep(3000)
            it
        }
            .map {
                val listEp = mutableListOf<CharacterEntity>()
                it.results.forEach {
                    listEp.add(it.toCharacterEntity())
                }
                listEp.toList()
            }
            .map {
                repo.insertList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}