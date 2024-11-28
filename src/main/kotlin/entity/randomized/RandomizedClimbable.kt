package net.radstevee.textadventure.entity.randomized

import net.radstevee.textadventure.entity.Climbable
import net.radstevee.textadventure.randomBool

interface RandomizedClimbable : Climbable {
    override fun canClimb(playerName: String) = randomBool()
}