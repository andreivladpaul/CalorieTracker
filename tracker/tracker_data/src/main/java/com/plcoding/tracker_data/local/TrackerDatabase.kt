package com.plcoding.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.tracker_data.local.entity.TrackedFoodEntity

/**
 * The Room database for the tracker feature.
 * It contains the `TrackedFoodEntity` table.
 */
@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {

    /**
     * The Data Access Object for the tracker database.
     */
    abstract val dao: TrackerDao
}