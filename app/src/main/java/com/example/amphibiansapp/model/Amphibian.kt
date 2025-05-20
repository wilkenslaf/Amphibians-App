package com.example.amphibiansapp.model

import com.squareup.moshi.Json

data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @Json(name = "img_src") val imgSrc: String
) 