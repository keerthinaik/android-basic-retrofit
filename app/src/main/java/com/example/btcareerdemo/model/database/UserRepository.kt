package com.example.btcareerdemo.model.database

import android.content.Context
import androidx.room.Room

class UserRepository(context: Context) {
    var userDatabase:UserDatabase = Room.databaseBuilder(
        context,
        UserDatabase::class.java, "user_database"
    ).build()

    val userDao = userDatabase.userDao()
}