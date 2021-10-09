package com.example.api_kelompok8

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val breed_id: Int,
    val breed_name: String?,
    val image: String?,
    val description: String?
)

