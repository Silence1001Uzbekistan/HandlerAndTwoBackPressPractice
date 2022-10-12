package com.example.handlerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var handler: Handler
    var gameOn = false
    var startTime: Long = 0

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTime = System.currentTimeMillis()

        handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                if (gameOn) {

                    val seconds = (System.currentTimeMillis() - startTime) / 1000
                    Log.d(TAG, "handleMessage: $seconds")

                }

                handler.sendEmptyMessageDelayed(0, 1000)

            }
        }

        gameOn = true
        handler.sendEmptyMessage(0)

    }
}