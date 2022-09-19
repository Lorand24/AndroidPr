package fundamentals

import java.util.*
import java.util.Random

fun main(){
    println("Hello world !")
    var age: Int = 20
    val name: String = "Kocsis Lorand"
    println("name : $name , age : $age .")

    // 1.
    var num1: Int = 3
    var num2: Int = 2
    println("$num1 + $num2 = ${num1 + num2} \n")

    // 2.
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for(day in daysOfWeek){
        println(day)
    }

    println("\n-Starts with letter T : ")
    for(day in daysOfWeek){
        if(day.startsWith("T")){
            println(day)
        }
    }

    println("\n-Contains e : ")
    for(day in daysOfWeek){
        if(day.contains("e")){
            println(day)
        }
    }

    println("\n-Length equals 6 : ")
    for(day in daysOfWeek){
        if(day.length == 6){
            println(day)
        }
    }

    // 3.
    println()
    checkPrime(6)
    checkPrime(7)
    println()
    generatePrim(20,50)

    // 4.
    println()
    val encodedMessage = encode("Alma a fa alatt .")
    println("\n" + encodedMessage)
    val decodedMessage = decode(encodedMessage)
    println(decodedMessage + "\n")

    println("Message coding : \n")
    val msgEncode = messageCoding("Alma a fa alatt .", ::encode)
    println(msgEncode)
    val msgDecode = messageCoding(msgEncode, ::decode)
    println(msgDecode)
    println()

    // 5.
    var myList = listOf(1, 4, 8, 5, 6, 9, 10, 13)
    println(filterList(myList))
    println()

    // 6.
    println(myList.map { it * it })
    println()
    println(daysOfWeek.map { it.toUpperCase() })
    println()
    println(daysOfWeek.map { it.first().toLowerCase() })
    println()
    println(daysOfWeek.map { it.length })
    println()
    println(daysOfWeek.map { it.length }.sum()/daysOfWeek.count())
    println()

    // 7.
    val days = daysOfWeek.toMutableList()
    for(day in daysOfWeek){
        if(day.contains("n")){
            days.remove(day)
        }
    }
    println(days)
    println()

    for(info in days.withIndex()){
        println("Item at ${info.index} is ${info.value}")
    }
    println()

    val sortedDays = days.sortedBy { it }
    println(sortedDays)
    println()

    // 8.
    val from = 0
    val to = 100
    val random = Random()
    var randomNumbers = IntArray(10) { random.nextInt(to - from)}.asList()
    for(number in randomNumbers){
        println(number)
    }
    println()

    val sortedRandomNumbers = randomNumbers.sortedBy { it }
    println(sortedRandomNumbers)
    println()

    for(number in randomNumbers){
        if (number % 2 == 0){
            println("The array contains even number $number")
        }
    }
    println()

    var evenArray = true
    for(number in randomNumbers){
        if (number % 2 != 0){
            evenArray = false
            println("The array contains odd number $number")
        }
    }
    if (evenArray){
        println("All the numbers are even ! \n")
    }else{
        println("\nThe array contains odd numbers ! \n")
    }

    var sum : Int = 0
    for(number in randomNumbers){
        sum += number
    }
    println(sum/randomNumbers.count())

    }


private fun checkPrime(number: Int): Boolean{
    var i = 2
    var flag = false
    while (i <= number / 2) {
        if (number % i == 0) {
            flag = true
            break
        }
        ++i
    }

    if(!flag){
        println("$number is a prime number.")
        return true
    }
    println("$number is not a prime number.")
    return false
}

private fun generatePrim(start: Int, end: Int){
    var low = start
    while (low < end) {
        var flag = false
        for (i in 2..low / 2) {
            if (low % i == 0) {
                flag = true
                break
            }
        }
        if(!flag){
            print("$low ")
        }
        ++low
    }
}

private fun encode(message: String): String{
    val encodedMessage = Base64.getEncoder().withoutPadding().encodeToString(message.toByteArray());
    return encodedMessage
}

private fun decode(encodedMessage: String): String{
    val decodedBytes = Base64.getDecoder().decode(encodedMessage)
    return String(decodedBytes)
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

fun filterList(x: List<Int>): List<Int> = x.filter { x -> x %2 == 0 }

