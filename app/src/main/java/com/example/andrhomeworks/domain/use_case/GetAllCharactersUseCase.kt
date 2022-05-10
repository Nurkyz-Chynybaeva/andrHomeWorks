package com.example.andrhomeworks.domain.use_case

import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.repo.Repo
import com.example.andrhomeworks.extensions.toCharacterEntity
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repo: Repo
) {
    operator fun invoke(): Observable<Unit> {
        return repo.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .map {
                val listEp = mutableListOf<CharacterEntity>()
                it.forEach {
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
