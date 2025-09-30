package com.plcoding.tracker_data.remote.dto


import com.squareup.moshi.Json

/**
 * Data Transfer Object for the nutritional information of a product from the Open Food Facts API.
 *
 * @property carbohydrates100g The amount of carbohydrates per 100g.
 * @property energyKcal100g The amount of energy in kilocalories per 100g.
 * @property fat100g The amount of fat per 100g.
 * @property proteins100g The amount of protein per 100g.
 */
data class Nutriments(
    @field:Json(name = "carbohydrates_100g")
    val carbohydrates100g: Double,
    @field:Json(name = "energy-kcal_100g")
    val energyKcal100g: Double,
    @field:Json(name = "fat_100g")
    val fat100g: Double,
    @field:Json(name = "proteins_100g")
    val proteins100g: Double
)