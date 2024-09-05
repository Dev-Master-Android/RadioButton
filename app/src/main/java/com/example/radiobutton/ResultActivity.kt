package com.example.radiobutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var resultTV: TextView
    private lateinit var levelTV: TextView
    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntExtra("ANSWER_FIVE", 0)
        resultTV = findViewById(R.id.resultTV)
        levelTV = findViewById(R.id.level)
        imageView = findViewById(R.id.imageView)
        resultTV.text = result.toString()
        characteristic(result)
    }

    private fun characteristic(result: Int) {
        when (result) {
            500 -> {
                levelTV.text = getString(R.string.great)
                imageView.setImageResource(R.drawable.great)
            }

            400 -> {
                levelTV.text = getString(R.string.good)
                imageView.setImageResource(R.drawable.good)
            }

            300 -> {
                levelTV.text = getString(R.string.norm)
                imageView.setImageResource(R.drawable.norm)
            }

            200 -> {
                levelTV.text = getString(R.string.unsatisfactory)
                imageView.setImageResource(R.drawable.unsatisfactory)
            }

            100 -> {
                levelTV.text = getString(R.string.bad)
                imageView.setImageResource(R.drawable.bad)
            }

            0 -> {
                levelTV.text = getString(R.string.very_bad)
                imageView.setImageResource(R.drawable.verybad)
            }
        }
    }
}