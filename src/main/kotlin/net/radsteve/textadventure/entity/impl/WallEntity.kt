package net.radsteve.textadventure.entity.impl

import net.radsteve.textadventure.entity.randomized.RandomizedClimbable
import net.radsteve.textadventure.gameLost
import net.radsteve.textadventure.gameWon
import net.radsteve.textadventure.i18n.I18nManager

class WallEntity : RandomizedClimbable {
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