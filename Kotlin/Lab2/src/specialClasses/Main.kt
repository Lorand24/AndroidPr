package specialClasses

import java.util.*

val c = Calendar.getInstance()

fun main(){
    val dates = arrayListOf<Date>()
    var validDates = 0;
    var date : Date

    while (validDates != 10){
        date = Date((1..2021).random(),(1..12).random(),(1..31).random())
        if (date.isValidDate()) {
            dates.add(date)
            validDates++
        }else{
            println("${date.toString()} is not valid !")
        }
    }

    dates.forEach {
        println(it.toString())
    }

    println("\n------ Sorted dates :")
    var sortedDates = dates.sortedWith(compareBy({it.year},{it.month},{it.day}))
    sortedDates.forEach {
        println(it.toString())
    }

    println("\n------ Reversed sorted dates :")
    sortedDates.asReversed().forEach{
        println(it.toString())
    }

    println("\n------ Custom sorted dates :")
    sortedDates = dates.sortedWith(compareBy({it.day},{it.month},{it.year}))
    sortedDates.forEach {
        println(it.toString())
    }
}

data class Date(val year: Int, val month: Int, val day: Int){
    constructor() : this(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)){}

    override fun toString(): String {
        return "Year: $year - Month: $month - Day: $day"
    }
}

fun Date.isLeapYear() : Boolean{
    val year = this.year
    var leap = false

    if (year % 4 == 0) {
        if (year % 100 == 0) {
            leap = year % 400 == 0
        } else{
            leap = true
        }
    } else{
        leap = false
    }
    return leap
}

fun Date.isValidDate() : Boolean{
    if(this.month < 1 || this.month > 12){
        return false
    }
    if(this.day < 1 || this.day > 31){
        return false
    }

    if(this.month == 2){
        if (this.isLeapYear()){
            return this.day <= 29
        }else{
            return this.day <= 28
        }
    }

    if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
        return this.day <= 30
    }

    return true
}

