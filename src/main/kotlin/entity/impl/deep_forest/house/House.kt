package net.radstevee.textadventure.entity.impl.deep_forest.house

import net.radstevee.textadventure.entity.Entity
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.prompt.Prompts
import net.radstevee.textadventure.scene.impl.deep_forest.HouseScene

class House : Entity {
    override fun toString() = I18nManager.translate("ENTITY_HOUSE")

    override fun interact(playerName: String) {
        if (!Prompts.promptBool(I18nManager.translate("ENTER_HOUSE_PROMPT"))) {
            return
        }

        println(I18nManager.translate("IN_HOUSE"))
        HouseScene(null).display(playerName)
    }
}
