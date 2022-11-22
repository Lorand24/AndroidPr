package com.example.quizapp.models

import android.content.Context
import android.util.Log
import com.example.quizapp.R
import com.example.quizapp.TAG_MAIN
import java.io.*
import java.util.*

const val TAG_QC : String = "QuizController"

class QuizController (var context: Context){

    val questions = arrayListOf<Question>()
    var score = 0
    var totalScore = 0
    var index = 0
    var highScore: HighScore = HighScore(context)

    init {
        //val lines = File("quizes.txt").readLines()
        Log.i(TAG_QC, "QC Init called")

        val isreader: InputStream = context.resources.openRawResource(R.raw.quizes)
        val reader = BufferedReader(InputStreamReader(isreader))
        val lines = reader.readLines()

        Log.i(TAG_QC, "QC readLines done")

        var textTemp = ""
        var answersTemp = arrayListOf<Answer>()

        for (i in 0..(lines.size - 1)){
            if (i % 5 == 0){
                textTemp = lines.get(i)
            }
            else {
                if (i % 5 == 1){
                    answersTemp.add(Answer(lines.get(i), true))
                }
                else {
                    answersTemp.add(Answer(lines.get(i)))
                }
                if (i % 5 == 4){
                    questions.add(Question(textTemp, answersTemp))
                    answersTemp = arrayListOf<Answer>()
                }
            }
        }
    }

    fun getNextQuestion() : Question {
        return questions[index]
    }

    fun randomizeQuestions() {
        questions.shuffle()
    }

    fun onAnswerChecked(index : Int) {
        if (questions[this.index++].answers[index].isCorrect) {
            score++
        }
    }

    fun doQuiz(num : Int) {
        randomizeQuestions()
        totalScore = num
        for (i in 0..(num-1)) {
            val reader = Scanner(System.`in`)
//            println(questions[i])

            println("Question: ${questions[i].text}\n")
            questions[i].answers.shuffle()

            println("Answers: \n")

//            questions[i].answers.forEach{ println("$it: ${it.text}") }

            for (j in 0..questions[i].answers.size - 1){
                println("$j: ${questions[i].answers[j].text}")
            }

            print("Your answer: ")
            var answNum = reader.nextInt()

            if (questions[i].answers[answNum].isCorrect) {
                println("The answer is correct! \n You have scored ${++score} points out of $totalScore")
            } else {
                println("The answer is incorrect! \n You have scored $score points out of $totalScore")
            }

            println("*********************************************")
        }
    }

    fun addQuestion(question: Question) {
//        val file = context.
    }
}