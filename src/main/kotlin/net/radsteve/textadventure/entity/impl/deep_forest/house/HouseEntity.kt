package net.radsteve.textadventure.entity.impl.deep_forest.house

import net.radsteve.textadventure.entity.Entity
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.prompt.Prompts
import net.radsteve.textadventure.scene.impl.deep_forest.house.HouseScene

class HouseEntity : Entity {
    override fun toString() = I18nManager.translate("ENTITY_HOUSE")

    override fun interact(playerName: String) {
        if (!Prompts.promptBool(I18nManager.translate("ENTER_HOUSE_PROMPT"))) {
            return
        }

        println(I18nManager.translate("IN_HOUSE"))
        HouseScene(null).display(playerName)
    }
}
