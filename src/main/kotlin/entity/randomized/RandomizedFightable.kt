package net.radstevee.textadventure.entity.randomized

import net.radstevee.textadventure.entity.Fightable
import net.radstevee.textadventure.randomBool

interface RandomizedFightable : Fightable {
    override fun hasWon(playerName: String) = randomBool()
}