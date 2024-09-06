package com.example.radiobutton


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.QuestionOne.IntentUtils.myIntent

class QuestionOne : AppCompatActivity() {

    private lateinit var answerOneBTN: Button
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private var resultCount = 0
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
            myIntent(this,"ANSWER",resultCount,QuestionTwo::class.java)
        }
    }
    object IntentUtils {
        fun myIntent(context: Context, key: String, resultCount: Int, activity: Class<out Activity>) {
            val intent = Intent(context, activity).apply {
                putExtra(key, resultCount)
            }
            context.startActivity(intent)
        }
    }
    private val checkCorrectAnswer =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when (radioButton.id) {
                R.id.firstAnswerOneRB -> resultCount += 0
                R.id.secondAnswerOneRB -> resultCount += 0
                R.id.thirdAnswerOneRB -> resultCount += 100
            }
        }
}