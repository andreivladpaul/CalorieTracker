package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * A use case for getting all tracked food items for a specific date.
 *
 * @param repository The [TrackerRepository] to interact with the data source.
 */
class GetFoodsForDate(
    private val repository: TrackerRepository
) {

    /**
     * Retrieves a flow of tracked food items for the given date.
     *
     * @param date The [LocalDate] for which to retrieve the food items.
     * @return A [Flow] emitting a list of [TrackedFood] items.
     */
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}