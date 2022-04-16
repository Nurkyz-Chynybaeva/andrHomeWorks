package com.example.andrhomeworks.domain.use_case

import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.repo.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterUseCase(
    private val repo: Repo
) {

    operator fun invoke(id: Long): Single<CharacterEntity> {
        return repo.getCharacterById(id)
            .map {
                Thread.sleep(2000)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}