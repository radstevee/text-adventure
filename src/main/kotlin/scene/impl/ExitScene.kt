package net.radstevee.textadventure.scene.impl

import net.radstevee.textadventure.entity.impl.Exit
import net.radstevee.textadventure.scene.InteractableScene
import net.radstevee.textadventure.scene.Scene

class ExitScene(override var parent: Scene?) : InteractableScene {
    override fun display(playerName: String) = Exit().interact(playerName)
}