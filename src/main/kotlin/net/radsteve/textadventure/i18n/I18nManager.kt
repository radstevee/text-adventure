package net.radsteve.textadventure.i18n


import java.util.*

object I18nManager {
    private const val FILE_PREFIX = "translations/game"

    private val defaultLocale: Locale = Locale.US
    private lateinit var currentBundle: ResourceBundle

    private val cache = mutableMapOf<String, String>()
    private val stringsCache = mutableMapOf<String, List<String>>()

    init {
        loadBundle(Locale.getDefault())
    }

    private fun loadBundle(locale: Locale) {
        currentBundle = runCatching {
            PropertyResourceBundle.getBundle(FILE_PREFIX, locale)
        }.getOrElse {
            PropertyResourceBundle.getBundle(FILE_PREFIX, defaultLocale)
        }
    }

    fun translate(key: String, vararg args: Any): String {
        cache[key]?.let { string -> return string.format(*args) }

        return runCatching {
            currentBundle.getString(key).format(*args)
        }.getOrElse { key }.also { value -> cache[key] = value }
    }

    fun translateStrings(key: String): List<String> {
        stringsCache[key]?.let { strings -> return strings }

        return currentBundle.getString(key).split(";").map(String::trim).also { value -> stringsCache[key] = value }
    }

    fun getYesInputs(): List<String> = translateStrings("YES_INPUTS")
    fun getNoInputs(): List<String> = translateStrings("NO_INPUTS")
    fun getLeftInputs(): List<String> = translateStrings("LEFT_INPUTS")
    fun getRightInputs(): List<String> = translateStrings("RIGHT_INPUTS")
    fun getUpInputs(): List<String> = translateStrings("UP_INPUTS")
    fun getDownInputs(): List<String> = translateStrings("DOWN_INPUTS")
    fun getExistsMessages(): List<String> = translateStrings("EXISTS_MESSAGES")
}
