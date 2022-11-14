package com.example.quizapp.shared

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Answer
import com.example.quizapp.models.HighScore
import com.example.quizapp.models.Question
import com.example.quizapp.models.QuizController
import java.io.File
import java.util.*

class QuizControllerViewModel(): ViewModel() {

    lateinit var quizController: QuizController
    var nrOfQuestions = 0
    var nameOfPlayer = ""


    init {

    }

    fun setUp(context: Context, nr: Int) {
        quizController = QuizController(context)
        quizController.randomizeQuestions()
        quizController.totalScore = nr

        nrOfQuestions = nr
    }

    fun setUp(context: Context, nr: Int, userName: String) {
        nameOfPlayer = userName
    }

    fun getNextQuestion() : Question {
        return quizController.getNextQuestion()
    }

    fun isLastQuestion() : Boolean = quizController.index >= nrOfQuestions

    fun onAnswerChecked(index : Int) {
        quizController.onAnswerChecked(index)
    }

    fun getFinalScore(): String {
        return "${quizController.score}/${quizController.totalScore} points"
    }

    fun getHighScore(): HighScore {
        return quizController.highScore
    }

    fun addQuestion(question: Question){
        quizController.addQuestion(question)
    }

}