package com.example.testhome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testhome.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        adapter = HomeAdapter(requireContext())
        binding.rvHome.adapter = adapter

        // Panggil API untuk mendapatkan data
        val apiService = ApiConfig.apiService
        val call = apiService.getHome()

        call.enqueue(object : Callback<ArrayList<UserResponse>> {
            override fun onResponse(
                call: Call<ArrayList<UserResponse>>,
                response: Response<ArrayList<UserResponse>>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    if (userList != null) {
                        adapter.setData(userList)
                    }
                } else {
                    Log.e("HomeFragment", "Failed to get data: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                Log.e("HomeFragment", "Error: ${t.message}")
            }
        })

        return view
    }
}
