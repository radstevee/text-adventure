package net.radsteve.textadventure.entity.randomized

import net.radsteve.textadventure.entity.Climbable
import net.radsteve.textadventure.randomBool

interface RandomizedClimbable : Climbable {
    override fun canClimb(playerName: String) = randomBool()
}