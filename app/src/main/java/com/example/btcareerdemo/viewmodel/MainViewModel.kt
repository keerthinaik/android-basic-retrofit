package com.example.btcareerdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.btcareerdemo.model.entities.User
import com.example.btcareerdemo.model.network.UserApiService
import com.example.btcareerdemo.model.util.LocalUserStore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val infoText:MutableLiveData<String> = MutableLiveData("Welcome")
    val statusText:MutableLiveData<String> = MutableLiveData("Please click start button to " +
            "download users data")
    val buttonText:MutableLiveData<String> = MutableLiveData("Start")

    fun startDownloading() {
        val usersDataFetchCallback = object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    var users = response.body()
                    if (users != null) {
                        LocalUserStore.USER_LIST = users
                        statusText.value = "downloaded successfully, click on view to display data"
                        infoText.value = "Successful"
                        buttonText.value = "view"
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                statusText.value = "downloading failed, click start to retry"
                infoText.value = "Unsuccessful"
            }
        }
        val userApiService = UserApiService()
        userApiService.getUsers().enqueue(usersDataFetchCallback)

    }
}