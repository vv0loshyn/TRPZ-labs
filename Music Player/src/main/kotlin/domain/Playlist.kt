package domain

import domain.iterator.Iterator
import domain.iterator.RepeatIterator
import domain.iterator.ShuffleIterator
import domain.iterator.SongIterator

class Playlist {
    private val songs = mutableListOf<Song>()

    fun addSong(song: Song) {
        songs.add(song)
    }

    fun createIterator(type: String): Iterator {
        return when (type) {
            "shuffle" -> ShuffleIterator(songs)
            "repeat" -> RepeatIterator(songs)
            else -> SongIterator(songs)
        }
    }
}