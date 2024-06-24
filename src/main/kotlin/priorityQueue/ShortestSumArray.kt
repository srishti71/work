package priorityQueue

import java.util.*

class ShortestSumArray {
    fun shortestSubarray(nums: IntArray, k: Int): Int {


        val array = ArrayDeque<Int>()
        val size = nums.size
        var res = Integer.MAX_VALUE

        val sumArray = IntArray(size+1){0}

        for(i in 0 until size) sumArray[i+1] = sumArray[i] + nums[i]

        for(i in 0 .. nums.size) {
            while(array.size > 0 && sumArray[i]- sumArray[array.peekFirst()] >= k)
                res = Math.min(res, i-array.pollFirst())
            while(array.size > 0 && sumArray[i] <= sumArray[array.peekLast()])
                array.removeLast()
            array.addLast(i)
        }

        return if(res <= size ) res else -1
    }
}

fun main() {
    val shortestSumArray = ShortestSumArray()
    println(shortestSumArray.shortestSubarray(
        intArrayOf(
            -34,
            37,
            51,
            3,
            -12,
            -50,
            51,
            100,
            -47,
            99,
            34,
            14,
            -13,
            89,
            31,
            -14,
            -44,
            23,
            -38,
            6
        ), 151
    ))
}