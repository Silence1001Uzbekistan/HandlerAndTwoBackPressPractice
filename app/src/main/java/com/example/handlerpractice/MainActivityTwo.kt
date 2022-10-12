package com.example.handlerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import com.example.handlerpractice.databinding.ActivityMainTwoBinding

class MainActivityTwo : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainTwoBinding
    private var counter = 0
    private var time: Long = 0L
    private lateinit var handlerT: Handler

    private var closeTime: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handlerT = Handler()

        if (time == 0L) {

            time = SystemClock.uptimeMillis()
            handlerT.removeCallbacks(runnable)
            handlerT.postDelayed(runnable, 100)

        }

        binding.button.setOnClickListener(this)

    }

    private var runnable = object : Runnable {
        override fun run() {

            val start = time
            val millis = SystemClock.uptimeMillis() - start
            var second = millis / 1000
            val minute = second / 60
            second %= 60

            binding.timeTv.text = "$minute:${String.format("%02d", second)}"
            handlerT.postDelayed(this, 200)

        }

    }

    override fun onPause() {
        super.onPause()

        handlerT.removeCallbacks(runnable)
        closeTime = SystemClock.uptimeMillis() - time

    }

    override fun onResume() {
        super.onResume()

        time = SystemClock.uptimeMillis() - closeTime
        handlerT.postDelayed(runnable, 100)

    }

    override fun onClick(p0: View?) {

        binding.counterTv.text = (++counter).toString()

    }

}