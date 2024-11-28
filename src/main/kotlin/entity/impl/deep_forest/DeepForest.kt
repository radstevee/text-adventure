package net.radstevee.textadventure.entity.impl.deep_forest

import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager

class DeepForest : Entity {
    override fun toString() = I18nManager.translate("ENTITY_DEEP_FOREST")

    override fun interact(playerName: String) {}
}