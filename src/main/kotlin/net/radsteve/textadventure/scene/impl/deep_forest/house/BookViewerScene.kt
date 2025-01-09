package net.radsteve.textadventure.scene.impl.deep_forest.house

import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.prompt.Prompts
import net.radsteve.textadventure.scene.Scene

class BookViewerScene(override var parent: Scene?) : Scene {
    private var page = 0
    private var shouldExit = false

    private companion object {
        const val PAGE_AMOUNT = 4
    }

    override fun display(playerName: String) {
        println(I18nManager.translate("BOOK_PAGE", 1))
        println(I18nManager.translateStringArray("BOOK_CONTENTS")[page].format(page))

        while (!shouldExit) {
            val direction = Prompts.promptLeftRight("")

            when {
                (direction == Direction.LEFT && page == 0) || (direction == Direction.RIGHT && page == PAGE_AMOUNT) -> {
                    val pageContent = I18nManager.translateStringArray("BOOK_CONTENTS")[page].format(page)

                    // No idea why but this is just 1 sometimes when it shouldn't be
                    println(I18nManager.translate("BOOK_PAGE", "${page + 1}").replace("1", "${page + 1}"))
                    println(pageContent)
                    continue
                }

                direction == Direction.LEFT -> {
                    page--
                }

                direction == Direction.RIGHT -> {
                    page++
                }

                direction == null -> {
                    parent?.display(playerName)
                    break
                }
            }

            val pageContent = I18nManager.translateStringArray("BOOK_CONTENTS")[page].format(page)

            // No idea why but this is just 1 sometimes when it shouldn't be
            println(I18nManager.translate("BOOK_PAGE", "${page + 1}").replace("1", "${page + 1}"))
            println(pageContent)
        }
    }
}
