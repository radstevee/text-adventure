package net.radsteve.textadventure.entity.impl


import net.radsteve.textadventure.entity.randomized.RandomizedFightable
import net.radsteve.textadventure.gameLost
import net.radsteve.textadventure.gameWon
import net.radsteve.textadventure.i18n.I18nManager

class Wolf : RandomizedFightable {
    override fun winFightDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_WON")

    override fun loseFightDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_LOST")

    override fun onLose(playerName: String) = gameLost()

    override fun onWin(playerName: String) = gameWon()

    override fun toString() = I18nManager.translate("ENTITY_WOLF")
}