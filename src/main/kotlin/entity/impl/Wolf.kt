package net.radstevee.textadventure.entity.impl


import net.radstevee.textadventure.entity.randomized.RandomizedFightable
import net.radstevee.textadventure.gameLost
import net.radstevee.textadventure.gameWon
import net.radstevee.textadventure.i18n.I18nManager

class Wolf : RandomizedFightable {
    override fun winFightDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_WON")

    override fun loseFightDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_LOST")

    override fun onLose(playerName: String) = gameLost()

    override fun onWin(playerName: String) = gameWon()

    override fun toString() = I18nManager.translate("ENTITY_WOLF")
}