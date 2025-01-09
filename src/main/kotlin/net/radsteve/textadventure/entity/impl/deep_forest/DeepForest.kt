package net.radsteve.textadventure.entity.impl.deep_forest

import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager

class DeepForest : Entity {
    override fun toString() = I18nManager.translate("ENTITY_DEEP_FOREST")

    override fun interact(playerName: String) {}
}