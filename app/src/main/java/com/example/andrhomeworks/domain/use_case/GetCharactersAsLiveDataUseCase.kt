package com.example.andrhomeworks.domain.use_case

import androidx.lifecycle.LiveData
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.data.repo.Repo
import javax.inject.Inject

class GetCharactersAsLiveDataUseCase @Inject constructor(
    private val  repo: Repo
) {
    operator fun invoke(): LiveData<List<CharacterEntity>> {
        return repo.getCharactersAsLive()
    }
}