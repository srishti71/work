package monotonicStack

import java.util.*

class LargestHistogram {

    fun largestRectangleArea(heights: IntArray): Int {
        val size = heights.size
        val nextSmaller = IntArray(size) { size }
        val prevSmaller = IntArray(size) { -1 }
        val stack = Stack<Int>()

        for (i in 0 until size) {
            while (stack.isNotEmpty() && heights[stack.peek()] > heights[i]) {
                nextSmaller[stack.pop()] = i
            }

            if (stack.isNotEmpty()) {
                prevSmaller[i] = stack.peek()
            }
            stack.push(i)
        }

        var result = 0
        for (i in 0 until size) {
            val width = nextSmaller[i] - prevSmaller[i] - 1
            result = Math.max(result, width * heights[i])
        }
        return result
    }
}

fun main() {
    val largestHistogram = LargestHistogram()
    largestHistogram.largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3))
}