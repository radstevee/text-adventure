package net.radsteve.textadventure.prompt


import net.radsteve.textadventure.Direction
import net.radsteve.textadventure.i18n.I18nManager
import kotlin.system.exitProcess

object Prompts {
    fun prompt(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ): String {
        println(prompt)

        print(fgColor)
        bgColor?.let(::print)
        if (bold) {
            print(AnsiColor.BOLD)
        }

        print(I18nManager.translate("PROMPT"))
        print(AnsiColor.RESET)
        print(" ")

        return try {
            readln()
        } catch (_: RuntimeException) {
            // We assume this is a ReadAfterEOFException which means that the process was closed before reading
            exitProcess(0)
        }
    }

    fun promptDirection(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ): Direction? = Direction.parse(prompt(prompt, fgColor, bgColor, bold).lowercase())

    fun promptBool(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ): Boolean = when (prompt(prompt + " " + I18nManager.translate("YES_NO"), fgColor, bgColor, bold).lowercase()) {
        in I18nManager.getYesInputs() -> true
        in I18nManager.getNoInputs() -> false

        else -> {
            println(I18nManager.translate("INVALID_INPUT"))
            promptBool(prompt, fgColor, bgColor, bold)
        }
    }

    fun promptLeftRight(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ): Direction? {
        val input = prompt(prompt + " " + I18nManager.translate("LEFT_RIGHT"), fgColor, bgColor, bold).lowercase()

        if (input in I18nManager.getLeftInputs()) {
            return Direction.LEFT
        }

        if (input in I18nManager.getRightInputs()) {
            return Direction.RIGHT
        }

        return null
    }
}
