package player.commands

import player.MusicPlayer

class PauseCommand(private val musicPlayer: MusicPlayer) : Command {
    override fun execute() {
        musicPlayer.pause()
    }
}