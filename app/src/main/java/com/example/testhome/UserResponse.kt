package com.example.testhome

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("job_title")
    val job_title: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("workplace")
    val workplace: String
)