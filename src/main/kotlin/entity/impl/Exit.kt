package net.radstevee.textadventure.entity.impl


import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager
import kotlin.system.exitProcess

class Exit : Entity {
    override fun toString() = I18nManager.translate("ENTITY_EXIT")

    override fun interact(playerName: String) {
        println(I18nManager.translate("EXITED"))
        exitProcess(0)
    }
}