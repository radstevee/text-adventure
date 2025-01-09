package net.radsteve.textadventure.scene.impl


import net.radsteve.textadventure.entity.Fightable
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.FightScene
import net.radsteve.textadventure.scene.Scene

class WolfFightScene(override val fightable: Fightable, override var parent: Scene? = null) : FightScene {
    override fun fightConfirmDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_CONFIRMATION")
}