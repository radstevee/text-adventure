package net.radstevee.textadventure.scene.impl

import net.radstevee.textadventure.entity.impl.Exit
import net.radstevee.textadventure.scene.InteractableScene
import net.radstevee.textadventure.scene.Scene

class ExitScene : InteractableScene {
    override var parent: Scene? = null

    override fun display(playerName: String) = Exit().interact(playerName)
}