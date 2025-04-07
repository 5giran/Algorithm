fun main() {
    val n = readLine()!!.toInt()
    val wordSet = mutableSetOf<String>()
    
    repeat(n) {
        wordSet.add(readLine()!!)
    }
    
    val wordList = wordSet.toList().sortedWith(compareBy(
        {it.length},
        {it}
    ))
    
    for (word in wordList) {
        println(word)
    }
}