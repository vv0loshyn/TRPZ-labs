package domain.iterator

import domain.Song

interface Iterator {
    fun hasNext(): Boolean
    fun next(): Song
}