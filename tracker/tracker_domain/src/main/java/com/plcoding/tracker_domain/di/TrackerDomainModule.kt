package com.plcoding.tracker_domain.di

import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.tracker_domain.repository.TrackerRepository
import com.plcoding.tracker_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * A Dagger Hilt module that provides dependencies for the tracker domain layer.
 */
@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    /**
     * Provides an instance of [TrackerUseCases].
     * This is a wrapper class for all the use cases in the tracker domain layer.
     *
     * @param repository The [TrackerRepository] implementation.
     * @param preferences The [Preferences] implementation.
     * @return An instance of [TrackerUseCases].
     */
    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}