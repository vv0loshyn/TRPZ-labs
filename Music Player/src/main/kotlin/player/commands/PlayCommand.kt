package player.commands

import player.MusicPlayer

class PlayCommand(private val musicPlayer: MusicPlayer) : Command {
    override fun execute() {
        musicPlayer.play()
    }
}