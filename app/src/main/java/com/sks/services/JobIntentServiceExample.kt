package com.sks.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceExample : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "JobIntent service is started")
        Log.d("Service Thread", Thread.currentThread().name)
    }

    companion object {
        fun myBackgroundService(context: Context, intent: Intent) {
            enqueueWork(context, JobIntentServiceExample::class.java, 1, intent)
        }
    }

    override fun onDestroy() {
        Log.d("Service", "JobIntent service is stopped")
        super.onDestroy()
    }
}