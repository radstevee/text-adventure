package net.radsteve.textadventure.scene.impl

import net.radsteve.textadventure.entity.impl.ExitEntity
import net.radsteve.textadventure.scene.InteractableScene
import net.radsteve.textadventure.scene.Scene

class ExitScene(override var parent: Scene?) : InteractableScene {
    override fun display(playerName: String) = ExitEntity().interact(playerName)
}