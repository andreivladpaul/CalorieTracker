package com.plcoding.tracker_data.repository

import com.plcoding.tracker_data.local.TrackerDao
import com.plcoding.tracker_data.mapper.toTrackableFood
import com.plcoding.tracker_data.mapper.toTrackedFood
import com.plcoding.tracker_data.mapper.toTrackedFoodEntity
import com.plcoding.tracker_data.remote.OpenFoodApi
import com.plcoding.tracker_domain.model.TrackableFood
import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

/**
 * The concrete implementation of the [TrackerRepository] interface.
 * It is responsible for fetching food data from the remote API and storing/retrieving
 * tracked food data from the local database.
 *
 * @param dao The Data Access Object for the tracker database.
 * @param api The Retrofit API for the Open Food Facts service.
 */
class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi
): TrackerRepository {

    /**
     * Searches for food items from the Open Food Facts API.
     * It filters out products where the stated calorie count doesn't align with the
     * calories calculated from macronutrients, to ensure data consistency.
     *
     * @param query The search query.
     * @param page The page number for pagination.
     * @param pageSize The number of items per page.
     * @return A [Result] containing a list of [TrackableFood] on success, or an error on failure.
     */
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products
                    .filter {
                        val calculatedCalories =
                            it.nutriments.carbohydrates100g * 4f +
                                it.nutriments.proteins100g * 4f +
                                    it.nutriments.fat100g * 9f
                        val lowerBound = calculatedCalories * 0.99f
                        val upperBound = calculatedCalories * 1.01f
                        it.nutriments.energyKcal100g in (lowerBound..upperBound)
                    }
                    .mapNotNull { it.toTrackableFood() }
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    /**
     * Inserts a tracked food item into the local database.
     *
     * @param food The [TrackedFood] to insert.
     */
    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    /**
     * Deletes a tracked food item from the local database.
     *
     * @param food The [TrackedFood] to delete.
     */
    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    /**
     * Retrieves all tracked food items for a specific date from the local database.
     *
     * @param localDate The date for which to retrieve the food items.
     * @return A [Flow] emitting a list of [TrackedFood] for the given date.
     */
    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}