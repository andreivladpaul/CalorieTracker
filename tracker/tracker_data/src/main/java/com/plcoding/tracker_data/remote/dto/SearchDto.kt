package com.plcoding.tracker_data.remote.dto

/**
 * Data Transfer Object for the search results from the Open Food Facts API.
 *
 * @property products A list of [Product] items that match the search query.
 */
data class SearchDto(
    val products: List<Product>,
)