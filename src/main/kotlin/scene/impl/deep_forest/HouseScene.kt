package net.radstevee.textadventure.scene.impl.deep_forest

import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.entity.impl.deep_forest.house.Drawer
import net.radstevee.textadventure.scene.MovingScene
import net.radstevee.textadventure.scene.Scene

class HouseScene(override var parent: Scene?) : MovingScene {
    override fun entityInDirection(playerName: String, direction: Direction) = when (direction) {
        Direction.LEFT -> Drawer()
        else -> null
    }

    override fun canMove(playerName: String, direction: Direction) = entityInDirection(playerName, direction) != null

    override fun move(playerName: String, direction: Direction) {
        entityInDirection(playerName, direction)?.interact(playerName)
    }

    override fun movePrompt(playerName: String) = ""

    override fun usesDisplayDirections(playerName: String) = true
}
