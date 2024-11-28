package net.radstevee.textadventure.entity.impl

import net.radstevee.textadventure.entity.randomized.RandomizedClimbable
import net.radstevee.textadventure.gameLost
import net.radstevee.textadventure.gameWon
import net.radstevee.textadventure.i18n.I18nManager

class Wall : RandomizedClimbable {
    override fun toString() = I18nManager.translate("ENTITY_WALL")

    override fun failClimbDialogue(playerName: String) = I18nManager.translate("FAILED_CLIMBING_WALL")

    override fun succeedClimbDialogue(playerName: String) = I18nManager.translate("SUCCESSFULLY_CLIMBED_WALL")

    override fun onFailClimb(playerName: String) {
        gameLost()
    }

    override fun onSucceedClimb(playerName: String) {
        gameWon()
    }
}