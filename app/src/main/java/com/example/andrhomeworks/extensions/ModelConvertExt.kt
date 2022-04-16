package com.example.andrhomeworks.extensions

import com.example.andrhomeworks.data.models.CharacterDto
import com.example.andrhomeworks.data.models.CharacterEntity

fun CharacterDto.toCharacterEntity(): CharacterEntity {

    return CharacterEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        image = this.image,
        url = this.url,
        created = this.created,
        episode = this.episode
    )
}