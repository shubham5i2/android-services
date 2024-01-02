package com.sks.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var startClassicService: Button
    private lateinit var startJobIntentService: Button
    private lateinit var stopClassicService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startClassicService = findViewById(R.id.startClassicService)
        startJobIntentService = findViewById(R.id.startJobIntentService)
        stopClassicService = findViewById(R.id.stopClassicService)

        startClassicService.setOnClickListener {
            val intent = Intent(this@MainActivity, ClassicServiceExample::class.java)
            startService(intent)
        }

        startJobIntentService.setOnClickListener {
            val intent = Intent(this@MainActivity, JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this@MainActivity, intent)
        }

        stopClassicService.setOnClickListener {
            val intent = Intent(this@MainActivity, ClassicServiceExample::class.java)
            stopService(intent)
        }
    }
}