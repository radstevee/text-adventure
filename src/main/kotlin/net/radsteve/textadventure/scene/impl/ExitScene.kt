package net.radsteve.textadventure.scene.impl

import net.radsteve.textadventure.entity.impl.Exit
import net.radsteve.textadventure.scene.InteractableScene
import net.radsteve.textadventure.scene.Scene

class ExitScene(override var parent: Scene?) : InteractableScene {
    override fun display(playerName: String) = Exit().interact(playerName)
}