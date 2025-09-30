package com.plcoding.tracker_data.di

import android.app.Application
import androidx.room.Room
import com.plcoding.tracker_data.local.TrackerDatabase
import com.plcoding.tracker_data.remote.OpenFoodApi
import com.plcoding.tracker_data.repository.TrackerRepositoryImpl
import com.plcoding.tracker_domain.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * A Dagger Hilt module that provides dependencies for the tracker data layer.
 * This includes the database, network API, and repository implementations.
 */
@Module
@InstallIn(SingletonComponent::class)
object TrackerDataModule {

    /**
     * Provides a singleton instance of [OkHttpClient] with a logging interceptor.
     * The logging interceptor is useful for debugging network requests.
     *
     * @return An instance of [OkHttpClient].
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    /**
     * Provides a singleton instance of [OpenFoodApi] for making network requests to the Open Food Facts API.
     *
     * @param client The [OkHttpClient] to be used by Retrofit.
     * @return An instance of [OpenFoodApi].
     */
    @Provides
    @Singleton
    fun provideOpenFoodApi(client: OkHttpClient): OpenFoodApi {
        return Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    /**
     * Provides a singleton instance of [TrackerDatabase] for local data storage.
     *
     * @param app The application context.
     * @return An instance of [TrackerDatabase].
     */
    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): TrackerDatabase {
        return Room.databaseBuilder(
            app,
            TrackerDatabase::class.java,
            "tracker_db"
        ).build()
    }

    /**
     * Provides a singleton instance of the [TrackerRepository] implementation.
     *
     * @param api The [OpenFoodApi] for remote data.
     * @param db The [TrackerDatabase] for local data.
     * @return An implementation of [TrackerRepository].
     */
    @Provides
    @Singleton
    fun provideTrackerRepository(
        api: OpenFoodApi,
        db: TrackerDatabase
    ): TrackerRepository {
        return TrackerRepositoryImpl(
            dao = db.dao,
            api = api
        )
    }
}