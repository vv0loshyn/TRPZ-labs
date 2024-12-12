package com.example.music.player.data.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "songs")
@Setter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String URL;
}
