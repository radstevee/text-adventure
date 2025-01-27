package net.radsteve.textadventure.entity.impl


import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager
import kotlin.system.exitProcess

class ExitEntity : Entity {
    override fun toString() = I18nManager.translate("ENTITY_EXIT")

    override fun interact(playerName: String) {
        println(I18nManager.translate("EXITED"))
        exitProcess(0)
    }
}