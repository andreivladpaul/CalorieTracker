package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository

/**
 * A use case for deleting a tracked food item from the local database.
 *
 * @param repository The [TrackerRepository] to interact with the data source.
 */
class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    /**
     * Deletes the given tracked food item.
     *
     * @param trackedFood The [TrackedFood] item to be deleted.
     */
    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}