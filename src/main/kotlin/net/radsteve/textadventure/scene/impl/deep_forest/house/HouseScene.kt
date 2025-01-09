package net.radsteve.textadventure.scene.impl.deep_forest.house

import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.entity.impl.deep_forest.house.Drawer
import net.radsteve.textadventure.entity.impl.deep_forest.house.Kitchen
import net.radsteve.textadventure.entity.impl.deep_forest.house.Room
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.MovingScene
import net.radsteve.textadventure.scene.Scene

class HouseScene(override var parent: Scene?) : MovingScene {
    override fun entityInDirection(playerName: String, direction: Direction) = when (direction) {
        Direction.LEFT -> Drawer(this)
        Direction.UP -> Kitchen(this)
        Direction.RIGHT -> Room(this)
        else -> null
    }

    override fun canMove(playerName: String, direction: Direction) = entityInDirection(playerName, direction) != null

    override fun move(playerName: String, direction: Direction) {
        entityInDirection(playerName, direction)?.interact(playerName)
    }

    override fun movePrompt(playerName: String) = I18nManager.translate("IN_HOUSE_PROMPT")

    override fun usesDisplayDirections(playerName: String) = true
}