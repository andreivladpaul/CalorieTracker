package com.plcoding.tracker_data.local

import androidx.room.*
import com.plcoding.tracker_data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for the tracker feature.
 * It provides methods to interact with the `trackedfoodentity` table in the database.
 */
@Dao
interface TrackerDao {

    /**
     * Inserts a [TrackedFoodEntity] into the database.
     * If a food item with the same primary key already exists, it will be replaced.
     *
     * @param trackedFoodEntity The food entity to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    /**
     * Deletes a [TrackedFoodEntity] from the database.
     *
     * @param trackedFoodEntity The food entity to be deleted.
     */
    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    /**
     * Retrieves all [TrackedFoodEntity] items for a specific date.
     *
     * @param day The day of the month.
     * @param month The month of the year.
     * @param year The year.
     * @return A [Flow] emitting a list of [TrackedFoodEntity] for the given date.
     */
    @Query(
        """
            SELECT *
            FROM trackedfoodentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>
}