package com.example.api_kelompok8

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/api/dogs")
    fun getPosts(): Call<ArrayList<PostResponse>>
}