package visitor

class FLACFile(val name: String, val sampleRate: Int) : MediaElement {
    override fun accept(visitor: MediaVisitor) {
        visitor.visit(this)
    }
}
