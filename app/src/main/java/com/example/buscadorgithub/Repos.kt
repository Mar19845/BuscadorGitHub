package com.example.buscadorgithub

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Repos (
    @Json(name="type")
    val type: String,
    val repoSrcUrl: String,
    // comprobar is el usuario existe y traer el Json

    val login:String,
    @Json(name = "avatar_url")
    val imgSrcUrl: String

)