package com.example.radiobutton


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class QuestionOne : AppCompatActivity() {

    private lateinit var answerOneBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_one)

        answerOneBTN = findViewById(R.id.answerOneBTN)
        answerOneRB = findViewById(R.id.firstAnswerOneRB)
        answerTwoRB = findViewById(R.id.secondAnswerOneRB)
        answerThreeRB = findViewById(R.id.thirdAnswerOneRB)

        answerOneRB.setOnClickListener(checkCorrectAnswer)
        answerTwoRB.setOnClickListener(checkCorrectAnswer)
        answerThreeRB.setOnClickListener(checkCorrectAnswer)
        answerOneBTN.setOnClickListener {
            val intent = Intent(this, QuestionTwo::class.java).apply {
                putExtra("ANSWER", result)
            }
            startActivity(intent)
        }
    }

    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerOneRB -> result += 0
                R.id.secondAnswerOneRB -> result += 0
                R.id.thirdAnswerOneRB -> result += 100
            }
        }
}