package extensions

fun main(){
    var name = "John smith"
    println(name.monogram())

    val words = arrayListOf<String>()
    words.add("apple")
    words.add("pear")
    words.add("melon")
    println(words.jointStrings())

    words.add("strawberry")
    println(words.longestString())
}

fun String.monogram() = this.split(" ").map { it.first().toUpperCase() }.joinToString(separator = "") { it.toString() }

fun List<String>.jointStrings() = this.joinToString(separator = "#") { it.toString() }

fun List<String>.longestString() = this.maxByOrNull { it.length }