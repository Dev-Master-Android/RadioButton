package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.QuestionOne.IntentUtils.myIntent

class QuestionFour : AppCompatActivity() {
    private lateinit var answerFourBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var resultCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_four)

        answerFourBTN = findViewById(R.id.answerFourBTN)
        answerOneRB = findViewById(R.id.firstAnswerFourRB)
        answerTwoRB = findViewById(R.id.secondAnswerFourRB)
        answerThreeRB = findViewById(R.id.thirdAnswerFourRB)

        answerOneRB.setOnClickListener(checkCorrectAnswer)
        answerTwoRB.setOnClickListener(checkCorrectAnswer)
        answerThreeRB.setOnClickListener(checkCorrectAnswer)
        val result = intent.getIntExtra("ANSWER_THREE", 0)
        resultCount += result
        answerFourBTN.setOnClickListener {
            myIntent(this,"ANSWER_FOUR",resultCount,QuestionFive::class.java)
        }
    }

    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerFourRB -> resultCount += 100
                R.id.secondAnswerFourRB -> resultCount += 0
                R.id.thirdAnswerFourRB -> resultCount += 0
            }
        }
}