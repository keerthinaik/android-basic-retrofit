package com.example.btcareerdemo.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class will represent the user model
 */
@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val phone: String,
    val email: String
)
