package net.radstevee.textadventure

import net.radstevee.textadventure.i18n.I18nManager

enum class Direction {
    LEFT, RIGHT, UP, DOWN;

    override fun toString() = when (this) {
        LEFT -> I18nManager.translate("LEFT")
        RIGHT -> I18nManager.translate("RIGHT")
        UP -> I18nManager.translate("UP")
        DOWN -> I18nManager.translate("DOWN")
    }

    fun toDisplayString() = when (this) {
        LEFT -> I18nManager.translate("LEFT_DISPLAY")
        RIGHT -> I18nManager.translate("RIGHT_DISPLAY")
        UP -> I18nManager.translate("UP_DISPLAY")
        DOWN -> I18nManager.translate("DOWN_DISPLAY")
    }

    companion object {
        fun parse(input: String) = when (input) {
            in I18nManager.getLeftInputs() -> LEFT
            in I18nManager.getRightInputs() -> RIGHT
            in I18nManager.getUpInputs() -> UP
            in I18nManager.getDownInputs() -> DOWN
            else -> null
        }
    }
}
