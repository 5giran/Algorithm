data class Person (
    val age: Int,
    val name: String,
    val index: Int
)

fun main() {
    val n = readln().toInt()
    val people = List(n) {  index ->
        val (age, name) = readln().split(" ")
        Person(age.toInt(), name, index)
    }
    
    val sorted = people.sortedWith(
        compareBy<Person> { it.age }
            .thenBy { it.index }
    )
    
    for (person in sorted) {
        println("${person.age} ${person.name}")
    }
}