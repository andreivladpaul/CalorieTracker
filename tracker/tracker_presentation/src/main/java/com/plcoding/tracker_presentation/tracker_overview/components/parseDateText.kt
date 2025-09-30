package com.plcoding.tracker_presentation.tracker_overview.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.plcoding.tracker_presentation.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * A composable function that parses a [LocalDate] and returns a human-readable string representation.
 * It displays "Today", "Yesterday", or "Tomorrow" for the respective dates,
 * otherwise it formats the date as "dd MMMM" (e.g., "01 January").
 *
 * @param date The [LocalDate] to be parsed.
 * @return A string representing the parsed date.
 */
@Composable
fun parseDateText(date: LocalDate): String {
    val today = LocalDate.now()
    return when(date) {
        today -> stringResource(id = R.string.today)
        today.minusDays(1) -> stringResource(id = R.string.yesterday)
        today.plusDays(1) -> stringResource(id = R.string.tomorrow)
        else -> DateTimeFormatter.ofPattern("dd LLLL").format(date)
    }
}