package com.example.btcareerdemo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.btcareerdemo.R
import com.example.btcareerdemo.model.businesslogic.UserDataDeleteWorker
import com.example.btcareerdemo.model.businesslogic.UsersDataStoreWorker

/**
 * Main Activity of the application
 */
class MainActivity : AppCompatActivity() {

    private lateinit var workManager:WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workManager = WorkManager.getInstance(applicationContext)
    }

    /**
     * This method is used to store the data into db
     */
    fun storeUsersData() {
        var storeUserDataWorkRequest: OneTimeWorkRequest = OneTimeWorkRequest
            .Builder(UsersDataStoreWorker::class.java).build()
        workManager.enqueue(storeUserDataWorkRequest)
    }

    /**
     * This method will remove the data from db once activity is destroyed just for demo purpose
     */
    fun removeUsersData() {
        var removeUserWorkRequest: OneTimeWorkRequest = OneTimeWorkRequest
            .Builder(UserDataDeleteWorker::class.java).build()
        workManager.enqueue(removeUserWorkRequest)
    }

    override fun onDestroy() {
        super.onDestroy()
        removeUsersData()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}