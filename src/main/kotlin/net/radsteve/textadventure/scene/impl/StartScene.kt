package net.radsteve.textadventure.scene.impl


import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.entity.impl.ExitEntity
import net.radsteve.textadventure.entity.impl.WallEntity
import net.radsteve.textadventure.entity.impl.WolfEntity
import net.radsteve.textadventure.entity.impl.deep_forest.DeepForestEntity
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.MovingScene
import net.radsteve.textadventure.scene.Scene
import net.radsteve.textadventure.scene.impl.deep_forest.DeepForestScene

class StartScene : MovingScene {
    override var parent: Scene? = null

    override fun entityInDirection(playerName: String, direction: Direction) = when (direction) {
        Direction.LEFT -> WolfEntity()
        Direction.RIGHT -> DeepForestEntity()
        Direction.UP -> WallEntity()
        Direction.DOWN -> ExitEntity()
    }

    override fun canMove(playerName: String, direction: Direction) = true

    override fun move(playerName: String, direction: Direction) {
        val subScene = when (direction) {
            Direction.LEFT -> WolfFightScene(WolfEntity())
            Direction.RIGHT -> DeepForestScene(this)
            Direction.UP -> WallClimbScene(WallEntity(), this)
            Direction.DOWN -> ExitScene(this)
        }

        startSubScene(playerName, subScene)
    }

    override fun movePrompt(playerName: String) = I18nManager.translate("DIRECTION_PROMPT")

    override fun usesDisplayDirections(playerName: String) = true
}