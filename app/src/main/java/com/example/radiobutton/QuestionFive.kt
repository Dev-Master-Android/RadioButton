package com.example.radiobutton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.QuestionOne.IntentUtils.myIntent

class QuestionFive : AppCompatActivity() {
    private lateinit var answerFiveBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var resultCount = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_five)
        answerFiveBTN = findViewById(R.id.answerFiveBTN)

        answerOneRB = findViewById(R.id.firstAnswerFiveRB)
        answerTwoRB = findViewById(R.id.secondAnswerFiveRB)
        answerThreeRB = findViewById(R.id.thirdAnswerFiveRB)

        answerOneRB.setOnClickListener(checkCorrectAnswer)
        answerTwoRB.setOnClickListener(checkCorrectAnswer)
        answerThreeRB.setOnClickListener(checkCorrectAnswer)
        val result = intent.getIntExtra("ANSWER_FOUR", 0)
        resultCount += result
        answerFiveBTN.setOnClickListener {
            myIntent(this,"ANSWER_FIVE",resultCount,ResultActivity::class.java)
        }
    }

    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerFiveRB -> resultCount += 0
                R.id.secondAnswerFiveRB -> resultCount += 100
                R.id.thirdAnswerFiveRB -> resultCount += 0
            }
        }
}