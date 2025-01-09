package net.radstevee.textadventure.scene.impl.deep_forest.house

import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.prompt.Prompts
import net.radstevee.textadventure.scene.Scene

class DrawerScene(override var parent: Scene?) : Scene {
    override fun display(playerName: String) {
        if (!Prompts.promptBool(I18nManager.translate("OPEN_DRAWER_PROMPT"))) {
            return
        }

        println(I18nManager.translate("DRAWER_INTERACTION"))

        if (!Prompts.promptBool(I18nManager.translate("BOOK_PROMPT"))) {
            return
        }

        BookViewerScene(parent).display(playerName)
    }
}
