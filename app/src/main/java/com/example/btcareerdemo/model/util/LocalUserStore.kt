package com.example.btcareerdemo.model.util

import com.example.btcareerdemo.model.entities.User

/**
 * This class will be used to store users data as a bridge to communicate with different classes
 */
class LocalUserStore {
    companion object {
        var USER_LIST:List<User>? = null
    }
}