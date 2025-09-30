package com.plcoding.tracker_data.remote.dto

import com.squareup.moshi.Json

/**
 * Data Transfer Object for a product from the Open Food Facts API.
 *
 * @property imageFrontThumbUrl The URL of the product's front thumbnail image.
 * @property nutriments The nutritional information of the product.
 * @property productName The name of the product.
 */
data class Product(
    @field:Json(name = "image_front_thumb_url")
    val imageFrontThumbUrl: String?,
    val nutriments: Nutriments,
    @field:Json(name = "product_name")
    val productName: String?
)