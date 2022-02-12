package com.example.btcareerdemo.model.network

import com.example.btcareerdemo.model.util.Constants
import com.example.btcareerdemo.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {

    @GET(Constants.USERS_API_ENDPOINT)
    fun getUsers() : Call<List<User>>
}