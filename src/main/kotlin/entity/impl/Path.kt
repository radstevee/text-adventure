package net.radstevee.textadventure.entity.impl

import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager

class Path : Entity {
    override fun toString() = I18nManager.translate("ENTITY_PATH")

    override fun interact(playerName: String) {}
}
