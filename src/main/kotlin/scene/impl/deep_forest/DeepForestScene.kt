package net.radstevee.textadventure.scene.impl.deep_forest

import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.scene.MovingScene
import net.radstevee.textadventure.scene.Scene

class DeepForestScene : MovingScene {
    override var parent: Scene? = null

    override fun entityInDirection(
        playerName: String,
        direction: Direction
    ): Entity {
        TODO("Not yet implemented")
    }

    override fun canMove(playerName: String, direction: Direction): Boolean {
        TODO("Not yet implemented")
    }

    override fun move(playerName: String, direction: Direction) {
        TODO("Not yet implemented")
    }

    override fun movePrompt(playerName: String): String {
        TODO("Not yet implemented")
    }

    override fun usesDisplayDirections(playerName: String): Boolean {
        TODO("Not yet implemented")
    }
}