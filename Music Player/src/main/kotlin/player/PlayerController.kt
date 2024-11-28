package player

import player.commands.Command

class PlayerController {
    private val commands = mutableMapOf<String, Command>()

    fun setCommand(button: String, command: Command) {
        commands[button] = command
    }

    fun pressButton(button: String) {
        commands[button]?.execute() ?: println("No command assigned to button '$button'.")
    }
}