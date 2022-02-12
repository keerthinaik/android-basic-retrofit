package com.example.btcareerdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.btcareerdemo.model.User
import com.example.btcareerdemo.model.network.UserApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userApiService:UserApiService = UserApiService()

        val users = userApiService.getUsers()

        users.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    var myUsers = response.body()
                    Log.e(TAG, "users is " + myUsers)
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

        Log.d(TAG, "users is $users")
        Log.d(TAG, "done")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}