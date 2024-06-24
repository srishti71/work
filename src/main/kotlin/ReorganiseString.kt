import java.util.*

class ReorganiseString {
    fun reorganizeString(s: String): String {
        val priorityQueue =
            PriorityQueue { a: Pair<Char, Int>, b: Pair<Char, Int> -> b.second - a.second }

        val map = mutableMapOf<Char, Int>()

        for (i in 0 until s.length) {
            map[s[i]] = map.getOrDefault(s[i], 0) + 1
        }

        for (ele in map.keys) priorityQueue.add(Pair(ele, map[ele]!!))

        var prev = ' '

        val sb = StringBuilder()

        while (priorityQueue.isNotEmpty()) {
            val top = priorityQueue.peek()
            var temp: Pair<Char, Int>? = null
            if (top.first == prev) {
                temp = priorityQueue.poll()
                if (priorityQueue.isEmpty()) return ""
            }
            val current = priorityQueue.poll()
            sb.append(current.first)
            prev = current.first
            if (current.second > 1)
                priorityQueue.add(Pair(current.first, current.second - 1))
            temp?.let {
                priorityQueue.add(it)
            }
        }
        return sb.toString()
    }
}

fun main() {
    val reorganiseString = ReorganiseString()
    println(reorganiseString.reorganizeString("aab"))
    println(reorganiseString.reorganizeString("aaab"))
    println(reorganiseString.reorganizeString("vvvlo"))
}