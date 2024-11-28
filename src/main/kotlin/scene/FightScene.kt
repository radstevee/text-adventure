package net.radstevee.textadventure.scene

import net.radstevee.textadventure.entity.Fightable
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.prompt.Prompts

interface FightScene : InteractableScene {
    val fightable: Fightable

    fun fightConfirmDialogue(playerName: String): String

    override fun display(playerName: String) {
        if (Prompts.promptBool(fightConfirmDialogue(playerName))) {
            fightable.fight(playerName)
        } else {
            println(I18nManager.translate("DOES_NOT_WANT_TO_FIGHT"))
        }
    }
}
