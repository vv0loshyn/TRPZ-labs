package facade

import java.net.URI

class StreamingService(
    private var streamSource: URI
) {
    fun connectToStream() {
        // establish connection with remote streaming service
    }

    fun bufferStream() : URI {
        // buffer streamed data to play song locally
        return URI("")
    }

    fun setStreamSource(newStreamSource: URI) {
        streamSource = newStreamSource
    }
}