package com.example.andrhomeworks

data class Response(
    val results: List<Episode>
)
data class Episode (
val id: Long?,
val name: String,
val status: String,
val species: String,
val type: String,
val gender: String,
val origin: Location,
val location: Location,
val image: String,
val episode: List<String>,
val url: String,
val created: String,
)

data class Location(
    val name: String,
    val url: String,
)