package net.radstevee.textadventure.entity

interface Entity {
    override fun toString(): String

    fun interact(playerName: String)
}
