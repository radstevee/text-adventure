package net.radstevee.textadventure.scene


import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.prompt.Prompts
import kotlin.system.exitProcess

interface MovingScene : InteractableScene {
    fun entityInDirection(playerName: String, direction: Direction): Entity?
    fun canMove(playerName: String, direction: Direction): Boolean
    fun move(playerName: String, direction: Direction)
    fun movePrompt(playerName: String): String

    fun usesDisplayDirections(playerName: String): Boolean

    override fun display(playerName: String) {
        Direction.entries.forEach { direction ->
            val directionString = if (usesDisplayDirections(playerName)) {
                direction.toDisplayString()
            } else {
                direction.toString()
            }

            entityInDirection(
                playerName,
                direction
            )?.let { entity ->
                println("$directionString ${I18nManager.getExistsMessages().random()} $entity.")
            }
        }

        val direction = Prompts.promptDirection(movePrompt(playerName))

        if (direction == null) {
            println(I18nManager.translate("INVALID_DIRECTION_INPUT"))
            exitProcess(0)
        }

        if (canMove(playerName, direction)) {
            move(playerName, direction)
        } else {
            println(I18nManager.translate("CANNOT_MOVE"))
        }
    }
}
