package com.example.andrhomeworks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val results: List<CharacterEntity>
)

@Entity
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)
