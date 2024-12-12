package com.example.music.player.service;

import com.example.music.player.data.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAllPlaylists();
    Playlist getPlaylistId(Long id);
    Playlist createPlaylist(Playlist playlist);
    //void add
}
