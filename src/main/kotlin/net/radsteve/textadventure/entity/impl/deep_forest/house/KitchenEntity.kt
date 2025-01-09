package net.radsteve.textadventure.entity.impl.deep_forest.house

import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.scene.Scene

class KitchenEntity(private val parentScene: Scene?) : Entity {
    override fun toString() = I18nManager.translate("ENTITY_KITCHEN")

    override fun interact(playerName: String) {
        println(I18nManager.translate("KITCHEN"))
        parentScene?.display(playerName)
    }
}