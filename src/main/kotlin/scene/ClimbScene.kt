package net.radstevee.textadventure.scene

import net.radstevee.textadventure.entity.Climbable
import net.radstevee.textadventure.prompt.Prompts

interface ClimbScene : InteractableScene {
    val climbable: Climbable

    fun prompt(playerName: String): String

    fun onDoesNotWantToClimb(playerName: String)

    override fun display(playerName: String) {
        val wantsToClimb = Prompts.promptBool(prompt(playerName))

        if (wantsToClimb) {
            climbable.climb(playerName)
        } else {
            onDoesNotWantToClimb(playerName)
        }
    }
}