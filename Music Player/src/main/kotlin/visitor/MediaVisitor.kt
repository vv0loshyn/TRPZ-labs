package visitor

interface MediaVisitor {
    fun visit(mp3File: MP3File)
    fun visit(flacFile: FLACFile)
    fun visit(wavFile: WAVFile)
}