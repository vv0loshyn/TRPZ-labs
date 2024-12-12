package com.example.music.player.web.controller;

import com.example.music.player.data.entity.Playlist;
import com.example.music.player.data.entity.PlaylistSongs;
import com.example.music.player.data.entity.Song;
import com.example.music.player.service.PlaylistService;
import com.example.music.player.service.PlaylistSongsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@AllArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
    private final PlaylistSongsService playlistSongsService;

    @GetMapping
    public ResponseEntity<List<Playlist>> getPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistId(id));
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(Playlist playlist) {
        return new ResponseEntity<>(playlistService.createPlaylist(playlist), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<List<Song>> getSongs(@PathVariable Long id) {
        return ResponseEntity.ok(playlistSongsService.getSongsByPlaylist(id));
    }

    @PostMapping("/{playlistId}")
    public ResponseEntity<PlaylistSongs> addSong(@PathVariable Long playlistId, Long songId) {
        return ResponseEntity.ok(playlistSongsService.addSongToPlaylist(playlistId, songId));
    }
}
