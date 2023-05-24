package com.example.testhome

import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisViewsModel : ViewModel() {
    private val apiService = ApiConfig.apiService

    fun registerUser(registerRequest: RegisRequest, onResult: (String) -> Unit) {
        val call = apiService.registerUser(registerRequest)
        call.enqueue(object : Callback<RegisResponse> {
            override fun onResponse(
                call: Call<RegisResponse>,
                response: Response<RegisResponse>
            ) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    val message = registerResponse?.message ?: "Pendaftaran berhasil!"
                    onResult(message)
                } else {
                    onResult("Pendaftaran gagal. Status code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<RegisResponse>, t: Throwable) {
                onResult("Pendaftaran gagal. Error: ${t.message}")
            }
        })
    }
}
