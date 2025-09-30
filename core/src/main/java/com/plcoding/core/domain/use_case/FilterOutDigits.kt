package com.plcoding.core.domain.use_case

/**
 * A use case to filter out non-digit characters from a string.
 */
class FilterOutDigits {

    /**
     * Filters the given text to keep only digit characters.
     *
     * @param text The input string to filter.
     * @return A new string containing only the digits from the input text.
     */
    operator fun invoke(text: String): String {
        return text.filter { it.isDigit() }
    }
}