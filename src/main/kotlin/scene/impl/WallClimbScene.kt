package net.radstevee.textadventure.scene.impl


import net.radstevee.textadventure.entity.Climbable
import net.radstevee.textadventure.gameLost
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.scene.ClimbScene
import net.radstevee.textadventure.scene.Scene

class WallClimbScene(override val climbable: Climbable) : ClimbScene {
    override var parent: Scene? = null

    override fun prompt(playerName: String) = I18nManager.translate("CLIMBING_WALL_PROMPT")

    override fun onDoesNotWantToClimb(playerName: String) = gameLost()
}