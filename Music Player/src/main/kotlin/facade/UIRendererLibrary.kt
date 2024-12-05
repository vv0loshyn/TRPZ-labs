package facade

class UIRendererLibrary {
    fun updateUI(uiState: InternalUIState) {
        // interacts with concrete low level player ui components
    }

    data class InternalUIState (
        val songProgress: Int,
    )
}