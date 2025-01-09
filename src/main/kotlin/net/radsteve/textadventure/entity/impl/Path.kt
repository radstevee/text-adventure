package net.radsteve.textadventure.entity.impl

import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager

class Path : Entity {
    override fun toString() = I18nManager.translate("ENTITY_PATH")

    override fun interact(playerName: String) {}
}
