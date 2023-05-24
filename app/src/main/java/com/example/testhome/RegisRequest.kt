package com.example.testhome

import com.google.gson.annotations.SerializedName

data class RegisRequest(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("phoneNumber")
    val phoneNumber: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,
)