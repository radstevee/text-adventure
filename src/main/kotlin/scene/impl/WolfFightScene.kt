package net.radstevee.textadventure.scene.impl


import net.radstevee.textadventure.entity.Fightable
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.scene.FightScene
import net.radstevee.textadventure.scene.Scene

class WolfFightScene(override val fightable: Fightable, override var parent: Scene? = null) : FightScene {
    override fun fightConfirmDialogue(playerName: String) = I18nManager.translate("WOLF_FIGHT_CONFIRMATION")
}