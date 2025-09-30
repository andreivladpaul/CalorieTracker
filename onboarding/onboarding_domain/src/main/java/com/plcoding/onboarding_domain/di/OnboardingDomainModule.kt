package com.plcoding.onboarding_domain.di

import com.plcoding.onboarding_domain.use_case.ValidateNutrients
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * A Dagger Hilt module that provides dependencies for the onboarding domain layer.
 */
@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {

    /**
     * Provides an instance of [ValidateNutrients] use case.
     * This use case is scoped to the ViewModel.
     *
     * @return An instance of [ValidateNutrients].
     */
    @Provides
    @ViewModelScoped
    fun provideValidateNutrientsUseCase(): ValidateNutrients {
        return ValidateNutrients()
    }
}