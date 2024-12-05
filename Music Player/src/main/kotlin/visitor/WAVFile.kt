package visitor

class WAVFile(val name: String, val channels: Int) : MediaElement {
    override fun accept(visitor: MediaVisitor) {
        visitor.visit(this)
    }
}
