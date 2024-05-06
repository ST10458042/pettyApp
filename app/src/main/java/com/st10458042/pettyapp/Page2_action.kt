package com.st10458042.pettyapp

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page2_action : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2_action)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Declarations
        val feed_button = findViewById<Button>(R.id.feed_button)
        val play_button = findViewById<Button>(R.id.play_button)
        val bath_button = findViewById<Button>(R.id.bath_button)
        val welcome = findViewById<ImageView>(R.id.petimages)
        val bongani = findViewById<TextView>(R.id.pet_action_text)

        progressBar = findViewById(R.id.pb_progress)
        timer = object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (100 * (millisUntilFinished / 10000.0f)).toInt()
                progressBar.progress = progress
            }

            override fun onFinish() {

            }
        }
        timer.start()



        feed_button.setOnClickListener {
            welcome.setImageResource(R.drawable.peteating)
            bongani.text = "thanks for feeding me"
            progressBar.progress = 0  // Reset progress to 0
            timer.cancel()  // Cancel the current timer
            timer.start()  // Restart the timer

        }
        play_button.setOnClickListener {
            welcome.setImageResource(R.drawable.pet_playing)
            bongani.text = "thanks for playing with me"

        }
        bath_button.setOnClickListener {
            welcome.setImageResource(R.drawable.pet_bathing)
            bongani.text = "I now feel fresh.Thank you"
        }
    }
}