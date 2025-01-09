package net.radsteve.textadventure.scene

import net.radsteve.textadventure.entity.Climbable
import net.radsteve.textadventure.prompt.Prompts

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