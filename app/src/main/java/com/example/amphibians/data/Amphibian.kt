package com.example.amphibians.data

import com.squareup.moshi.Json

data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @Json(name = "img_src") val imgSrc: String
) 