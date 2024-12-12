package org.example.music.player.data.song

import org.example.music.player.data.song.entities.CreateSongRequestEntity
import org.example.music.player.data.song.entities.GetSongResponseEntity
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SongApi {

    @GET("songs")
    suspend fun getSongs(): List<GetSongResponseEntity>

    @GET("songs/{id}")
    suspend fun getSong(@Path("id") id: Long): GetSongResponseEntity

    @POST("songs")
    suspend fun createSong(
        createSongRequestEntity: CreateSongRequestEntity
    )

    @DELETE("songs/{id}")
    suspend fun deleteSong(@Path("id") id: Long)
}