package com.example.music.player.service.mapper;

import com.example.music.player.data.entity.PlaylistSongs;
import com.example.music.player.data.entity.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {
    List<Song> toSong(List<PlaylistSongs> playlistSongs);
}
