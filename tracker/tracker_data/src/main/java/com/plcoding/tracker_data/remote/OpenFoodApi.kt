package com.plcoding.tracker_data.remote

import com.plcoding.tracker_data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A Retrofit API interface for interacting with the Open Food Facts API.
 */
interface OpenFoodApi {

    /**
     * Searches for food products based on a query.
     *
     * @param query The search terms.
     * @param page The page number for pagination.
     * @param pageSize The number of results per page.
     * @return A [SearchDto] containing the search results.
     */
    @GET("cgi/search.pl?search_simple=1&json=1&action=process&fields=product_name,nutriments,image_front_thumb_url")
    suspend fun searchFood(
        @Query("search_terms") query: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): SearchDto

    /**
     * Companion object containing constants for the API.
     */
    companion object {
        /**
         * The base URL for the Open Food Facts API.
         */
        const val BASE_URL = "https://us.openfoodfacts.org/"
    }
}