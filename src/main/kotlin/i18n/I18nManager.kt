package net.radstevee.textadventure.i18n


import java.util.*

object I18nManager {
    const val FILE_PREFIX = "translations/game"

    val defaultLocale = Locale.of("en", "US")
    lateinit var currentBundle: ResourceBundle

    private val cache = mutableMapOf<String, String>()
    private val stringListCache = mutableMapOf<String, List<String>>()

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
        if (key in cache) return cache[key]!!.format(*args)

        return runCatching {
            currentBundle.getString(key).format(*args)
        }.getOrElse { key }.also { value -> cache[key] = value }
    }

    fun translateStringArray(key: String): List<String> {
        if (key in stringListCache) return stringListCache[key]!!

        return currentBundle.getString(key).split(",").map(String::trim).also { value -> stringListCache[key] = value }
    }

    fun getYesInputs() = translateStringArray("YES_INPUTS")
    fun getNoInputs() = translateStringArray("NO_INPUTS")
    fun getLeftInputs() = translateStringArray("LEFT_INPUTS")
    fun getRightInputs() = translateStringArray("RIGHT_INPUTS")
    fun getUpInputs() = translateStringArray("UP_INPUTS")
    fun getDownInputs() = translateStringArray("DOWN_INPUTS")
    fun getExistsMessages() = translateStringArray("EXISTS_MESSAGES")
}
