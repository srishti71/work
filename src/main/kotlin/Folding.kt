class Folding {
}

fun main() {
    val list = listOf(
        Element("1", "a", "1"),
        Element("1", "b", "2"),
        Element("1", "d", "4"),
        Element("1", "c", "3"),
        Element("2", "d", "4")
    )

    val element = list.sortedBy { it.timeStamp }.groupingBy { it.caseId }
        .fold(listOf<String>()) { acc, ele -> acc + ele.activityName }
    println("List is ${element}")

}


data class Element(val caseId: String, val activityName: String, val timeStamp: String)