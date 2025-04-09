data class Student (
    val name: String,
    val koreanScore: Int,
    val englishScore: Int,
    val mathScore: Int
)

fun main() {
    val n = readln().toInt()
    val students = List(n) {
        val (name, kor, eng, math) = readln().split(" ")
        Student(name, kor.toInt(), eng.toInt(), math.toInt())
    }

    val sorted = students.sortedWith(
        compareByDescending<Student> { it.koreanScore }
            .thenBy { it.englishScore }
            .thenByDescending { it.mathScore }
            .thenBy { it.name }
    )

    for (student in sorted) {
        println(student.name)
    }
}