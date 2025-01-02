package net.radstevee.textadventure.entity.impl.deep_forest.house

import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.scene.Scene
import net.radstevee.textadventure.scene.impl.deep_forest.house.DrawerScene

class Drawer(private val parentScene: Scene) : Entity {
    override fun toString() = I18nManager.translate("ENTITY_DRAWER")

    override fun interact(playerName: String) {
        DrawerScene(parentScene).display(playerName)
    }
}
