package facade

import java.net.URI

class AudioPlayerLibrary {
    fun loadSource(source: URI) {
        // load media source for concrete low level media components
    }

    fun playAudio(uiObserver: (UIState) -> Unit) {
        // start playing with concrete low level media components
    }

    fun stopAudio() {
        // stop playing with concrete low level media components
    }

    data class UIState (
        val songProgress: Int,
    )
}