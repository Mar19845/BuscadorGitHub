package com.example.buscadorgithub

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Repos (
    @Json(name="type")
    val type: String,
    val repoSrcUrl: String
)