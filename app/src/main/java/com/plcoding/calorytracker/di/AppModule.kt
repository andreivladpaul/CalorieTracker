package com.plcoding.calorytracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.plcoding.core.data.preferences.DefaultPreferences
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.use_case.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * A Dagger Hilt module that provides application-level dependencies.
 * This includes dependencies that are used across multiple features,
 * such as SharedPreferences, Preferences, and core use cases.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provides a singleton instance of [SharedPreferences].
     *
     * @param app The application context.
     * @return An instance of [SharedPreferences].
     */
    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    /**
     * Provides a singleton instance of the [Preferences] interface.
     *
     * @param sharedPreferences The [SharedPreferences] instance to be used by the preferences implementation.
     * @return An implementation of the [Preferences] interface.
     */
    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    /**
     * Provides a singleton instance of the [FilterOutDigits] use case.
     *
     * @return An instance of [FilterOutDigits].
     */
    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }
}