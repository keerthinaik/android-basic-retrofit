package com.example.btcareerdemo.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.btcareerdemo.model.entities.User

@Dao
interface UserDao {
    @Insert
    fun insertAll(user:List<User>);

    @Delete
    fun deleteAll(users: List<User>)

    @Query("SELECT * FROM user")
    fun getAllUsers():LiveData<List<User>>
}