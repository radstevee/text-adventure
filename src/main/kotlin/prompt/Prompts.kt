package net.radstevee.textadventure.prompt


import net.radstevee.textadventure.Direction
import net.radstevee.textadventure.i18n.I18nManager

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
        if (bold) print(AnsiColor.BOLD)

        print(I18nManager.translate("PROMPT"))
        print(AnsiColor.RESET)
        print(" ")

        return readln()
    }

    fun promptDirection(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ) = Direction.parse(prompt(prompt, fgColor, bgColor, bold).lowercase())

    fun promptBool(
        prompt: String,
        fgColor: AnsiColor = AnsiColor.AQUA,
        bgColor: AnsiColor? = null,
        bold: Boolean = false
    ) = when (prompt(prompt + " " + I18nManager.translate("YES_NO"), fgColor, bgColor, bold).lowercase()) {
        in I18nManager.getYesInputs() -> true
        in I18nManager.getNoInputs() -> false

        else -> {
            println(I18nManager.translate("INVALID_BOOL_INPUT"))
            false
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
