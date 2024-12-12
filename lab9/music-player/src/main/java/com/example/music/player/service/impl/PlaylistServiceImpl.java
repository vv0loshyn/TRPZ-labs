package com.example.music.player.service.impl;

import com.example.music.player.data.entity.Playlist;
import com.example.music.player.data.repository.PlaylistRepository;
import com.example.music.player.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist getPlaylistId(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
