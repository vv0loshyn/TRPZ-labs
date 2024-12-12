package com.example.music.player.data.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "playlists")
@Setter
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
