package org.example.music.player.data.song.entities

import org.example.music.player.domain.song.entitties.Song

data class GetSongResponseEntity(
    val id: Long,
    val name: String,
    val uri: String
) {
    fun toSong(): Song = Song(
        id, name, uri
    )
}