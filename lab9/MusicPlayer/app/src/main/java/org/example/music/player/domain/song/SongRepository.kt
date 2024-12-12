package org.example.music.player.domain.song

import org.example.music.player.domain.song.entitties.Song

interface SongRepository {

    suspend fun getSongs(): List<Song>

    suspend fun getSongById(id: Long): Song

    suspend fun addSong(song: Song)

    suspend fun deleteSongById(id: Long)
}