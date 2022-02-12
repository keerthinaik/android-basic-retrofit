package com.example.btcareerdemo.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.btcareerdemo.model.database.UserDatabase
import com.example.btcareerdemo.model.database.UserRepository
import com.example.btcareerdemo.model.entities.User

class UserListViewModel : ViewModel() {

    var context: Context? = null

    fun getUserData(): LiveData<List<User>>? {
        if (context != null) {
            UserDatabase.getDatabase(context!!)
            return UserRepository(context!!).userDao.getAllUsers()
        }
        return null
    }

}