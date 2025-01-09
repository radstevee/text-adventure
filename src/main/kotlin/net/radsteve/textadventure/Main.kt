package net.radsteve.textadventure

import net.radsteve.textadventure.i18n.I18nManager
import net.radsteve.textadventure.prompt.AnsiColor
import net.radsteve.textadventure.prompt.Prompts.prompt
import net.radsteve.textadventure.prompt.Prompts.promptBool
import net.radsteve.textadventure.scene.impl.StartScene
import kotlin.random.Random
import kotlin.system.exitProcess

fun randomBool() = Random.nextDouble(0.0, 1.0) >= 0.55

fun gameWon() {
    print(AnsiColor.GREEN_BACKGROUND)
    print(AnsiColor.BRIGHT_BLACK)
    print(AnsiColor.BOLD)
    print(I18nManager.translate("GAME_WON"))
    println(AnsiColor.RESET)

    exitProcess(0)
}

fun gameLost() {
    print(AnsiColor.RED_BACKGROUND)
    print(AnsiColor.BRIGHT_BLACK)
    print(AnsiColor.BOLD)
    print(I18nManager.translate("GAME_LOST"))
    println(AnsiColor.RESET)

    exitProcess(0)
}

fun main() {
    val playerName = prompt(I18nManager.translate("NAME_PROMPT"))
    println(I18nManager.translate("WELCOME_TEXT", playerName))

    val wantsToEnter = promptBool(I18nManager.translate("FOREST_PROMPT"))
    if (!wantsToEnter) {
        println(I18nManager.translate("DOES_NOT_WANT_TO_ENTER", playerName))
        gameLost()
    }

    StartScene().display(playerName)

    // only gets called once all scenes end without exiting, thus we lose.
    gameLost()
}
