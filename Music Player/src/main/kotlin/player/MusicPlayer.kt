package player

import domain.Playlist
import domain.iterator.SongIterator

class MusicPlayer(private val playlist: Playlist) {
    private var iterator: SongIterator = playlist.createIterator("")

    fun setIterator(type: String) {
        iterator = playlist.createIterator(type)
        println("Iterator switched to $type mode.")
    }

    fun play() {
        val currentSong = if (iterator.hasNext()) iterator.next() else null
        if (currentSong != null) {
            println("Playing: ${currentSong.name} - ${currentSong.songUrl}")
        } else {
            println("End of playlist or no songs available.")
        }
    }

    fun pause() {
        println("Playback paused.")
    }

    fun nextTrack() {
        if (iterator.hasNext()) {
            val nextSong = iterator.next()
            println("Playing next: ${nextSong.name}")
        } else {
            println("No more songs in the playlist.")
        }
    }
}