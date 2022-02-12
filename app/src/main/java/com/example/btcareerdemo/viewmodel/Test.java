package com.example.btcareerdemo.viewmodel;

import com.example.btcareerdemo.model.User;
import com.example.btcareerdemo.model.network.UserApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {

    void get() {
        UserApiService userApiService = new UserApiService();

        Call<List<User>> users = userApiService.getUsers();
        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
