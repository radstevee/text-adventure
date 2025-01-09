package net.radsteve.textadventure.entity

interface Fightable : Entity {
    fun hasWon(playerName: String): Boolean
    fun winFightDialogue(playerName: String): String
    fun loseFightDialogue(playerName: String): String

    fun onLose(playerName: String)
    fun onWin(playerName: String)

    fun fight(playerName: String) {
        if (hasWon(playerName)) {
            println(winFightDialogue(playerName))
            onWin(playerName)
        } else {
            println(loseFightDialogue(playerName))
            onLose(playerName)
        }
    }

    override fun interact(playerName: String) {
        fight(playerName)
    }
}