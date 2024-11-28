package player.commands

import player.MusicPlayer

class SwitchIteratorCommand(
    private val musicPlayer: MusicPlayer,
    private val type: String
) : Command {
    override fun execute() {
        musicPlayer.setIterator(type)
    }
}