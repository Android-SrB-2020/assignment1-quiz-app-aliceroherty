package com.nbcc.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.nbcc.quiz.Question

class MainActivity : AppCompatActivity() {
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0

    private lateinit var questionView : TextView

    private lateinit var trueButton : Button
    private lateinit var falseButton : Button
    private lateinit var nextButton : Button
    private lateinit var backButton : Button

    private lateinit var correctToast : Toast
    private lateinit var incorrectToast : Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        correctToast = Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT)
        incorrectToast = Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT)

        questionView = findViewById(R.id.questionView)
        questionView.setText(questionBank[questionIndex].textResID)

        trueButton = findViewById(R.id.btnTrue)
        trueButton.setOnClickListener {
            if(questionBank[questionIndex].answer) {
                //Indicate that the user was correct with a toast
                correctToast.show()
            } else {
                //Indicate that the user was incorrect with a toast
                incorrectToast.show()
            }
        }

        falseButton = findViewById(R.id.btnFalse)
        falseButton.setOnClickListener {
            if(!questionBank[questionIndex].answer) {
                //Indicate that the user was correct with a toast
                correctToast.show()
            } else {
                //Indicate that the user was incorrect with a toast
                incorrectToast.show()
            }
        }

        nextButton = findViewById(R.id.btnNext)
        nextButton.setOnClickListener {
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].textResID)
        }

        backButton = findViewById(R.id.btnBack)
        backButton.setOnClickListener {
            questionIndex = if (questionIndex != 0) { questionIndex - 1 } else { 19 }
            questionView.setText(questionBank[questionIndex].textResID)
        }
    }
}
