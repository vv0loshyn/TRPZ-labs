package com.example.music.player.service;

import com.example.music.player.data.entity.PlaylistSongs;
import com.example.music.player.data.entity.Song;

import java.util.List;

public interface PlaylistSongsService {
    PlaylistSongs addSongToPlaylist(Long playlistId, Long songId);
    List<Song> getSongsByPlaylist(Long playlistId);
}
