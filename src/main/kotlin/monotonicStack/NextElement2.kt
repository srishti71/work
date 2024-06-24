package monotonicStack

import java.util.*

class NextElement2 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val stack = Stack<Int>()
        val size = nums.size
        val result = IntArray(size) { -1 }
        for (i in 0 until nums.size) {
            while (stack.isNotEmpty() && nums[i] > nums[stack.peek()]) {
                val ele = stack.pop()
                result[ele] = nums[i]
            }
            stack.push(i)
        }
        val list = stack.toList()
        if (stack.isNotEmpty()) {
            for (i in 0 until nums.size) {
                if (result[i] == -1 && i != list[0]) {
                    result[i] = nums[list[0]]
                }
            }
        }


        return result
    }
}

fun main() {
    val nextElement2 = NextElement2()
    val result  = nextElement2.nextGreaterElements(intArrayOf(1,2,3,4,3))
    result.map {
        println(it)
    }
}