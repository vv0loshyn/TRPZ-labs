package domain.iterator

import domain.Song

class ShuffleIterator(songs: List<Song>) : SequentialIterator(songs) {
    private val shuffledSongs: List<Song> = songs.shuffled()

    override fun hasNext(): Boolean {
        return position < shuffledSongs.size
    }

    override fun next(): Song {
        return shuffledSongs[position++]
    }
}