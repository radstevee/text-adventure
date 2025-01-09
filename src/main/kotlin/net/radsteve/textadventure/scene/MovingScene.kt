package net.radsteve.textadventure.scene


import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.prompt.Prompts

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
            println(I18nManager.translate("INVALID_INPUT"))
            display(playerName)
            return
        }

        if (canMove(playerName, direction)) {
            move(playerName, direction)
        } else {
            println(I18nManager.translate("CANNOT_MOVE"))
            display(playerName)
        }
    }
}
