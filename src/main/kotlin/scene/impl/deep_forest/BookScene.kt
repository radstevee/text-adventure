package net.radstevee.textadventure.scene.impl.deep_forest

import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.i18n.I18nManager
import net.radstevee.textadventure.prompt.Prompts
import net.radstevee.textadventure.scene.Scene

class BookScene(override var parent: Scene?) : Scene {
    private var page = 0
    private var shouldExit = false

    private companion object {
        const val PAGE_AMOUNT = 10
    }

    override fun display(playerName: String) {
        println(I18nManager.translate("BOOK_PAGE", page))
        println(I18nManager.translateStringArray("BOOK_CONTENTS")[page].format(page))

        while (!shouldExit) {
            val direction = Prompts.promptLeftRight("")

            if (direction == Direction.LEFT && page == 0 || direction == Direction.RIGHT && page == PAGE_AMOUNT) {
                continue
            }

            if (direction == Direction.LEFT) {
                page--
            }

            if (direction == Direction.RIGHT) {
                page++
            }

            val pageContent = I18nManager.translateStringArray("BOOK_CONTENTS")[page].format(page)

            println(I18nManager.translate("BOOK_PAGE", "-1"))
            println(I18nManager.translate("BOOK_PAGE").replace("%s", "$page")) // ???
            println(pageContent)
        }
    }
}
