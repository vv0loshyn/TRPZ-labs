package com.example.music.player.service.impl;

import com.example.music.player.data.entity.Playlist;
import com.example.music.player.data.entity.PlaylistSongs;
import com.example.music.player.data.entity.Song;
import com.example.music.player.data.repository.PlaylistSongsRepository;
import com.example.music.player.service.PlaylistSongsService;
import com.example.music.player.service.mapper.SongMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistSongsServiceImpl implements PlaylistSongsService {
    private final PlaylistSongsRepository playlistSongsRepository;
    private final SongMapper songMapper;

    @Override
    public PlaylistSongs addSongToPlaylist(Long playlistId, Long songId) {
        PlaylistSongs playlistSong = new PlaylistSongs();

        Playlist playlist = new Playlist();
        playlist.setId(playlistId);
        Song song = new Song();
        song.setId(songId);

        playlistSong.setPlaylist(playlist);
        playlistSong.setSong(song);

        return playlistSongsRepository.save(playlistSong);
    }

    @Override
    public List<Song> getSongsByPlaylist(Long playlistId) {
        return songMapper.toSong(playlistSongsRepository.findByPlaylist(playlistId));
    }
}
