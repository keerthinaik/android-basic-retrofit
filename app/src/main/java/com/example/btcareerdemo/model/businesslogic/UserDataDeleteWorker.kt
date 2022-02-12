package com.example.btcareerdemo.model.businesslogic

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.btcareerdemo.model.database.UserRepository
import com.example.btcareerdemo.model.util.LocalUserStore

/**
 * Worked to remove all data from db
 */
class UserDataDeleteWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        if (LocalUserStore.USER_LIST != null) {
            UserRepository(applicationContext).userDao.deleteAll(LocalUserStore.USER_LIST!!)
        }
        return Result.success()
    }
}