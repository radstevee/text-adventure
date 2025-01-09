package net.radsteve.textadventure.entity

interface Entity {
    override fun toString(): String

    fun interact(playerName: String)
}
