package com.plcoding.core.util

import android.content.Context
import androidx.annotation.StringRes

/**
 * A sealed class to represent text that can be either a dynamic [String] or a string resource from Android.
 * This helps in keeping ViewModels free from Android framework dependencies like `Context`.
 */
sealed class UiText {
    /**
     * A [UiText] that holds a plain string.
     *
     * @param text The string value.
     */
    data class DynamicString(val text: String): UiText()

    /**
     * A [UiText] that holds a reference to a string resource.
     *
     * @param resId The resource ID of the string.
     */
    data class StringResource(@StringRes val resId: Int): UiText()

    /**
     * Resolves the [UiText] to a [String].
     *
     * @param context The [Context] used to resolve the string resource if this is a [StringResource].
     * @return The resolved [String].
     */
    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId)
        }
    }
}
