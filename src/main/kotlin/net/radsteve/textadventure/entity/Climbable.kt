package net.radsteve.textadventure.entity

interface Climbable : Entity {
    fun canClimb(playerName: String): Boolean

    fun failClimbDialogue(playerName: String): String
    fun succeedClimbDialogue(playerName: String): String

    fun onFailClimb(playerName: String)
    fun onSucceedClimb(playerName: String)

    fun climb(playerName: String) {
        if (canClimb(playerName)) {
            println(succeedClimbDialogue(playerName))
            onSucceedClimb(playerName)
        } else {
            println(failClimbDialogue(playerName))
            onFailClimb(playerName)
        }
    }

    override fun interact(playerName: String) {
        climb(playerName)
    }
}