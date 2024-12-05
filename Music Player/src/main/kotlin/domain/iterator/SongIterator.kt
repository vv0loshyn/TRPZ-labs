package domain.iterator

import domain.Song

interface SongIterator {
    fun hasNext(): Boolean
    fun next(): Song
}