package net.radsteve.textadventure.scene.impl.deep_forest

import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.entity.impl.Path
import net.radsteve.textadventure.entity.impl.deep_forest.house.House
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.MovingScene
import net.radsteve.textadventure.scene.Scene

class DeepForestScene(override var parent: Scene?) : MovingScene {
    private var moveCount = 0
    private val texts = I18nManager.translateStringArray("DEEPER_INTO_FOREST")
    private val house = House()

    override fun entityInDirection(
        playerName: String,
        direction: Direction
    ): Entity? {
        if (direction == Direction.UP && moveCount < 6) {
            return Path()
        }

        if (moveCount >= 6 && direction == Direction.LEFT) {
            return house
        }

        return null
    }

    override fun canMove(playerName: String, direction: Direction): Boolean {
        if (direction == Direction.UP && moveCount < 6) {
            return true
        }

        if (moveCount >= 6 && direction == Direction.LEFT) {
            return true
        }

        return false
    }

    override fun move(playerName: String, direction: Direction) {
        if (moveCount < 6) {
            moveCount++

            println(texts[moveCount - 1])

            startSubScene(playerName, this)
        } else {
            house.interact(playerName)
        }
    }

    override fun movePrompt(playerName: String) = I18nManager.translate("DEEP_FOREST_MOVE_PROMPT")

    override fun usesDisplayDirections(playerName: String) = true
}
