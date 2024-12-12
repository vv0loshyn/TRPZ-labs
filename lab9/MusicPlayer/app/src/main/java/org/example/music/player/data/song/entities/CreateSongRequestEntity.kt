package org.example.music.player.data.song.entities

data class CreateSongRequestEntity(
    val id: Long,
    val name: String,
    val uri: String
)
