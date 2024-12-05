package domain.iterator

import domain.Song

class RepeatIterator(private val songs: List<Song>) : SequentialIterator(songs) {

    override fun hasNext(): Boolean {
        return songs.isNotEmpty()
    }

    override fun next(): Song {
        val song = songs[position]
        position = (position + 1) % songs.size // Зациклення
        return song
    }
}