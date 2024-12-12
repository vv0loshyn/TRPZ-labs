package com.example.music.player.service;

import com.example.music.player.data.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    Song createSong(Song song);
    void deleteSongById(Long id);
}
