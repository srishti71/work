import java.util.*

class MinOperationThreshold {
    fun minOperations(nums: IntArray, k: Int): Int {
        var result = 0

        val pq = PriorityQueue<Long>() { a: Long, b: Long -> a.compareTo(b) }

        for (ele in nums) pq.add(ele.toLong())

        while (pq.isNotEmpty()) {
            val first = if (pq.peek() < k) pq.poll() else Long.MAX_VALUE
            if (pq.isEmpty()) break
            val second = if (pq.peek() < k) pq.poll() else Long.MAX_VALUE

            if (first == Long.MAX_VALUE || second == Long.MAX_VALUE) break

            result++
            val sum = first * 2 + second
            pq.add(sum)
        }
        return result
    }
}

fun main() {
    val minOperationThreshold = MinOperationThreshold()
}

