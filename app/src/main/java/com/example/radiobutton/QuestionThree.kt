package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.QuestionOne.IntentUtils.myIntent

class QuestionThree : AppCompatActivity() {
    private lateinit var answerThreeBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var resultCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_three)

        answerThreeBTN = findViewById(R.id.answerThreeBTN)
        answerOneRB = findViewById(R.id.firstAnswerThreeRB)
        answerTwoRB = findViewById(R.id.secondAnswerThreeRB)
        answerThreeRB = findViewById(R.id.thirdAnswerThreeRB)

        answerOneRB.setOnClickListener(checkCorrectAnswer)
        answerTwoRB.setOnClickListener(checkCorrectAnswer)
        answerThreeRB.setOnClickListener(checkCorrectAnswer)
        val result = intent.getIntExtra("ANSWER_TWO", 0)
        resultCount += result
        answerThreeBTN.setOnClickListener {
            myIntent(this,"ANSWER_THREE",resultCount,QuestionFour::class.java)
        }
    }

    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerThreeRB -> resultCount += 100
                R.id.secondAnswerThreeRB -> resultCount += 0
                R.id.thirdAnswerThreeRB -> resultCount += 0
            }
        }
}