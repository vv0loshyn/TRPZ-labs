package player

class PlayerStateManager {
    private val savedStates = mutableListOf<MusicPlayer.Memento>()

    fun saveState(player: MusicPlayer) {
        savedStates.add(player.saveState())
        println("State saved.")
    }

    fun restoreState(player: MusicPlayer) {
        if (savedStates.isNotEmpty()) {
            val lastState = savedStates.last()
            player.restoreState(lastState)
            savedStates.removeAt(savedStates.size - 1)
        } else {
            println("No state to restore.")
        }
    }
}