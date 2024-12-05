package visitor

class MP3File(val name: String, val bitrate: Int) : MediaElement {
    override fun accept(visitor: MediaVisitor) {
        visitor.visit(this)
    }
}