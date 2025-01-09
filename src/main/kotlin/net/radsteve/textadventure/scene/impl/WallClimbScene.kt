package net.radsteve.textadventure.scene.impl


import net.radsteve.textadventure.entity.Climbable
import net.radsteve.textadventure.gameLost
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.ClimbScene
import net.radsteve.textadventure.scene.Scene

class WallClimbScene(override val climbable: Climbable, override var parent: Scene?) : ClimbScene {
    override fun prompt(playerName: String) = I18nManager.translate("CLIMBING_WALL_PROMPT")

    override fun onDoesNotWantToClimb(playerName: String) = gameLost()
}