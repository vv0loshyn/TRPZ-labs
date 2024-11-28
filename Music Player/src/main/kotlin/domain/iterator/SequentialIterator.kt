package domain.iterator

import domain.Song

open class SequentialIterator(private val songs: List<Song>) : SongIterator {
    protected var position = 0

    override fun hasNext(): Boolean {
        return position < songs.size
    }

    override fun next(): Song {
        return songs[position++]
    }
}