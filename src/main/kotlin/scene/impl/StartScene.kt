package net.radstevee.textadventure.scene.impl


import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.entity.impl.Exit
import net.radstevee.textadventure.entity.impl.Wall
import net.radstevee.textadventure.entity.impl.Wolf
import net.radstevee.textadventure.entity.impl.deep_forest.DeepForest
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.scene.MovingScene
import net.radstevee.textadventure.scene.Scene
import net.radstevee.textadventure.scene.impl.deep_forest.DeepForestScene

class StartScene : MovingScene {
    override var parent: Scene? = null

    override fun entityInDirection(playerName: String, direction: Direction) = when (direction) {
        Direction.LEFT -> Wolf()
        Direction.RIGHT -> DeepForest()
        Direction.UP -> Wall()
        Direction.DOWN -> Exit()
    }

    override fun canMove(playerName: String, direction: Direction) = true

    override fun move(playerName: String, direction: Direction) {
        val subScene = when (direction) {
            Direction.LEFT -> WolfFightScene(Wolf())
            Direction.RIGHT -> DeepForestScene()
            Direction.UP -> WallClimbScene(Wall())
            Direction.DOWN -> ExitScene()
        }

        startSubScene(playerName, subScene)
    }

    override fun movePrompt(playerName: String) = I18nManager.translate("DIRECTION_PROMPT")

    override fun usesDisplayDirections(playerName: String) = true
}