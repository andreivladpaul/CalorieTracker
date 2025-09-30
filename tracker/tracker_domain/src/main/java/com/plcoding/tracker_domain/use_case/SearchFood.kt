package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.TrackableFood
import com.plcoding.tracker_domain.repository.TrackerRepository

/**
 * A use case for searching for food items from a remote source.
 *
 * @param repository The [TrackerRepository] to interact with the data source.
 */
class SearchFood(
    private val repository: TrackerRepository
) {

    /**
     * Searches for food items based on a query.
     *
     * @param query The search query. If the query is blank, an empty list will be returned.
     * @param page The page number for pagination. Defaults to 1.
     * @param pageSize The number of items per page. Defaults to 40.
     * @return A [Result] containing a list of [TrackableFood] on success, or an error on failure.
     */
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if(query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}