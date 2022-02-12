package com.example.btcareerdemo.model.network

import com.example.btcareerdemo.model.util.Constants
import com.example.btcareerdemo.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserApiService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val userAPI:UserAPI = retrofit.create(UserAPI::class.java)

    fun getUsers(): Call<List<User>> {
        return userAPI.getUsers()
    }
}