package com.example.buscadorgithub.data

import com.example.buscadorgithub.Repos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubRepo {
    @GET("/users/{valors}/repos")
    fun listRepos(@Path("valors") user: String?): Call<List<Repos>>
}