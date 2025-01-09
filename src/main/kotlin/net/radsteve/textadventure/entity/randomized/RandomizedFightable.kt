package net.radsteve.textadventure.entity.randomized

import net.radsteve.textadventure.entity.Fightable
import net.radsteve.textadventure.randomBool

interface RandomizedFightable : Fightable {
    override fun hasWon(playerName: String) = randomBool()
}