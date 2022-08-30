package com.example.kronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.example.kronometer.R.style.Theme_AppCompat_Dark
import com.example.kronometer.R.style.Theme_Kronometer_Dark
import com.example.kronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val theme = super.getTheme()
        theme.applyStyle(R.style.Theme_Kronometer_Light, true)
        var time:Long = 0

        binding.startButton.setOnClickListener{
            binding.startButton.setText("Devam Ettir")
            binding.startButton.textSize = 12F
            binding.startButton.visibility = View.GONE
            binding.startButtonImage.visibility = View.GONE
            binding.pauseButton.visibility = View.VISIBLE
            binding.pauseButtonImage.visibility = View.VISIBLE
            binding.chronometer.base = SystemClock.elapsedRealtime() + time
            binding.chronometer.start()
        }
        binding.resetButton.setOnClickListener{
            binding.startButton.setText("Başlat")
            binding.startButton.textSize = 22F
            binding.startButton.visibility = View.VISIBLE
            binding.startButtonImage.visibility = View.VISIBLE
            binding.pauseButton.visibility = View.GONE
            binding.pauseButtonImage.visibility = View.GONE
            binding.chronometer.stop()
            binding.chronometer.setText("00:00")
            time = 0
        }
        binding.pauseButton.setOnClickListener{
            binding.startButton.visibility = View.VISIBLE
            binding.startButtonImage.visibility = View.VISIBLE
            binding.pauseButton.visibility = View.GONE
            binding.pauseButtonImage.visibility = View.GONE
            time = binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()
        }
    }
}