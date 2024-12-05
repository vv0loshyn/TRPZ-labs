package visitor

class AudioAnalyzer : MediaVisitor {
    override fun visit(mp3File: MP3File) {
        println("Analyzing MP3 file: ${mp3File.name}, bitrate: ${mp3File.bitrate} kbps")
    }

    override fun visit(flacFile: FLACFile) {
        println("Analyzing FLAC file: ${flacFile.name}, sample rate: ${flacFile.sampleRate} Hz")
    }

    override fun visit(wavFile: WAVFile) {
        println("Analyzing WAV file: ${wavFile.name}, channels: ${wavFile.channels}")
    }
}