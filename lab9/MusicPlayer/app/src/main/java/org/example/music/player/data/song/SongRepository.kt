package org.example.music.player.data.song

import org.example.music.player.data.base.BaseRetrofitSource
import org.example.music.player.data.base.RetrofitConfig
import org.example.music.player.domain.song.SongRepository
import org.example.music.player.domain.song.entitties.Song
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SongRepository @Inject constructor(
    config: RetrofitConfig
): BaseRetrofitSource(config), SongRepository {

    private val songApi= retrofit.create(SongApi::class.java)

    override suspend fun getSongs(): List<Song> =
        wrapRetrofitExceptions {
            songApi.getSongs().map { it.toSong() }
        }

    override suspend fun getSongById(id: Long): Song {
        TODO("Not yet implemented")
    }

    override suspend fun addSong(song: Song) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSongById(id: Long) {
        TODO("Not yet implemented")
    }
}