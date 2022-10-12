package com.example.handlerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.handlerpractice.databinding.ActivityMainThreeBinding

class MainActivityThree : AppCompatActivity() {

    lateinit var binding: ActivityMainThreeBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        handler.postDelayed(runnable, 1000)

    }

    private var runnable = object : Runnable {
        override fun run() {

            binding.progressBar.progress = binding.progressBar.progress + 2
            Thread.sleep(1000)
            handler.postDelayed(this, 1000)

        }
    }

}