import quiz.Question
import quiz.QuizController
import java.util.*

fun main() {
    val quiz : QuizController = QuizController()

    val reader = Scanner(System.`in`)
    println("How many questions do you want? (MAX: 10)")
    var num = reader.nextInt()

    quiz.doQuiz(num)
}