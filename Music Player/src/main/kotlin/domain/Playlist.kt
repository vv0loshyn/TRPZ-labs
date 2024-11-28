package domain

import domain.iterator.SongIterator
import domain.iterator.RepeatIterator
import domain.iterator.ShuffleIterator
import domain.iterator.SequentialIterator

class Playlist {
    private val songs = mutableListOf<Song>()

    fun addSong(song: Song) {
        songs.add(song)
    }

    fun createIterator(type: String): SongIterator {
        return when (type) {
            "shuffle" -> ShuffleIterator(songs)
            "repeat" -> RepeatIterator(songs)
            else -> SequentialIterator(songs)
        }
    }
}