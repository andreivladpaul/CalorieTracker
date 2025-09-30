package com.plcoding.tracker_domain.repository

import com.plcoding.tracker_domain.model.TrackableFood
import com.plcoding.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * An interface defining the contract for the tracker repository.
 * This repository is responsible for all data operations related to food tracking.
 */
interface TrackerRepository {

    /**
     * Searches for food items from a remote source.
     *
     * @param query The search query.
     * @param page The page number for pagination.
     * @param pageSize The number of items per page.
     * @return A [Result] containing a list of [TrackableFood] on success, or an error on failure.
     */
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    /**
     * Inserts a tracked food item into the local database.
     *
     * @param food The [TrackedFood] to insert.
     */
    suspend fun insertTrackedFood(food: TrackedFood)

    /**
     * Deletes a tracked food item from the local database.
     *
     * @param food The [TrackedFood] to delete.
     */
    suspend fun deleteTrackedFood(food: TrackedFood)

    /**
     * Retrieves all tracked food items for a specific date.
     *
     * @param localDate The date for which to retrieve the food items.
     * @return A [Flow] emitting a list of [TrackedFood] for the given date.
     */
    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}