package quiz

import java.io.File
import java.util.*

class QuizController {

    val questions = arrayListOf<Question>()
    var score = 0
    var totalScore = 0

    init {
        val lines = File("quizes.txt").readLines()

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

    fun randomizeQuestions() {
        questions.shuffle()
    }
}