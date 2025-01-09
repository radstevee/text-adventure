package net.radsteve.textadventure.entity.impl.deep_forest.house

import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.Scene
import net.radsteve.textadventure.scene.impl.deep_forest.house.DrawerScene

class Drawer(private val parentScene: Scene) : Entity {
    override fun toString() = I18nManager.translate("ENTITY_DRAWER")

    override fun interact(playerName: String) {
        DrawerScene(parentScene).display(playerName)
    }
}
