package com.example.handlerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.handlerpractice.databinding.ActivityTwoBackPressedBinding

class TwoBackPressedActivity : AppCompatActivity() {

    lateinit var binding: ActivityTwoBackPressedBinding

    lateinit var handler: Handler
    private var isBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBackPressedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

    }

    override fun onBackPressed() {

        if (isBack) {

            super.onBackPressed()
            return

        }

        isBack = true

        Toast.makeText(this, "Please again click", Toast.LENGTH_SHORT).show()

        handler.postDelayed({

            isBack = false

        }, 2000)

    }

}