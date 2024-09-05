package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class QuestionTwo : AppCompatActivity() {

    private lateinit var answerTwoBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var resultCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_two)

        answerTwoBTN = findViewById(R.id.answerTwoBTN)
        answerOneRB = findViewById(R.id.firstAnswerTwoRB)
        answerTwoRB = findViewById(R.id.secondAnswerTwoRB)
        answerThreeRB = findViewById(R.id.thirdAnswerTwoRB)

        answerOneRB.setOnClickListener(checkCorrectAnswer)
        answerTwoRB.setOnClickListener(checkCorrectAnswer)
        answerThreeRB.setOnClickListener(checkCorrectAnswer)
        val res = intent.getIntExtra("ANSWER", 0)
        resultCount += res
        answerTwoBTN.setOnClickListener {
            val intent = Intent(this, QuestionThree::class.java).apply {
                putExtra("ANSWER_TWO", resultCount)
            }
            startActivity(intent)
        }
    }

    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerTwoRB -> resultCount += 100
                R.id.secondAnswerTwoRB -> resultCount += 0
                R.id.thirdAnswerTwoRB -> resultCount += 0
            }
        }
}