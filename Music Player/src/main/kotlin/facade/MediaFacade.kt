package facade

import domain.Song
import facade.AudioPlayerLibrary.UIState
import facade.UIRendererLibrary.InternalUIState
import java.net.URI

class MediaFacade(
    private val audioPlayer: AudioPlayerLibrary,
    private val uiRenderer: UIRendererLibrary,
    private val streamingService: StreamingService
) {
    fun playSong(song: Song) {
        val uri = URI(song.songPath)
        if (uri.scheme == "http" || uri.scheme == "https") {
            playStreamedSong(uri)
        } else {
            playLocalSong(uri)
        }
    }

    private fun playLocalSong(filePath: URI) {
        audioPlayer.loadSource(filePath)
        audioPlayer.playAudio {
            updateUIProgress(it)
        }
    }

    private fun playStreamedSong(streamURL: URI) {
        streamingService.setStreamSource(streamURL)
        streamingService.connectToStream()
        val bufferedDataPath = streamingService.bufferStream()
        audioPlayer.loadSource(bufferedDataPath)
        audioPlayer.playAudio {
            updateUIProgress(it)
        }
    }

    fun stopPlayback() {
        audioPlayer.stopAudio()
    }

    private fun updateUIProgress(uiState: UIState) {
        // mapping to internal state
        val state = InternalUIState(uiState.songProgress)
        uiRenderer.updateUI(state)
    }
}