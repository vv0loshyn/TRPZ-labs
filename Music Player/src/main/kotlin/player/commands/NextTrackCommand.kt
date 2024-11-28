package player.commands

import player.MusicPlayer

class NextTrackCommand(private val musicPlayer: MusicPlayer) : Command {
    override fun execute() {
        musicPlayer.nextTrack()
    }
}