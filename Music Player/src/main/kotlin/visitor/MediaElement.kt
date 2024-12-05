package visitor

interface MediaElement {
    fun accept(visitor: MediaVisitor)
}