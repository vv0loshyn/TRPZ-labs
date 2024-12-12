package com.example.music.player.data.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "playlist_songs")
@Setter
public class PlaylistSongs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;
    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;
}
