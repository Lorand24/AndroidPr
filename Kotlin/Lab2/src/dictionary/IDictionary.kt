package dictionary

interface IDictionary {
    companion object{
        val fileName = "dictionary.txt"
    }

    fun add(word: String) : Boolean
    fun find(word: String) : Boolean
    fun size() : Int

}