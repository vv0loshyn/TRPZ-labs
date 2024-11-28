package player

import domain.Playlist
import domain.Song
import domain.iterator.SongIterator

class MusicPlayer(private val playlist: Playlist) {
    private var iterator: SongIterator = playlist.createIterator("")
    private var currentSong: Song? = null
    private var isPaused: Boolean = false
    private var currentIndex: Int = 0

    fun setIterator(type: String) {
        iterator = playlist.createIterator(type)
        println("Iterator switched to $type mode.")
    }

    fun play() {
        if (iterator.hasNext()) {
            currentSong = iterator.next()
            println("Playing: ${currentSong?.name} - ${currentSong?.songUrl}")
            isPaused = false
        } else {
            println("End of playlist or no songs available.")
        }
    }

    fun pause() {
        println("Playback paused.")
        isPaused = true
    }

    fun nextTrack() {
        if (iterator.hasNext()) {
            currentSong = iterator.next()
            println("Playing next: ${currentSong?.name}")
            isPaused = false
        } else {
            println("No more songs in the playlist.")
        }
    }

    fun saveState(): Memento {
        return Memento(currentIndex, iterator::class.simpleName ?: "", isPaused, currentSong)
    }

    fun restoreState(memento: Memento) {
        this.currentIndex = memento.index
        this.iterator = playlist.createIterator(memento.iteratorType)
        this.isPaused = memento.isPaused
        this.currentSong = memento.song
        println("State restored: ${currentSong?.name} ${if (isPaused) "paused" else "playing"}")
    }

    data class Memento(
        val index: Int,
        val iteratorType: String,
        val isPaused: Boolean,
        val song: Song?
    )
}