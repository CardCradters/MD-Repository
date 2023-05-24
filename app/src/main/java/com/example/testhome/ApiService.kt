package com.example.testhome

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("api/homepage")
    fun getHome(): Call<ArrayList<UserResponse>>

    @POST("register")
    fun registerUser(
        @Body registerRequest: RegisRequest
    ): Call<RegisResponse>


}



