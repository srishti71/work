package greedy

import java.util.*

class MedianEqualTok {
    fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
        if(nums.size == 1) {
            return Math.abs(nums[0]-k).toLong()
        }
        val isOdd = nums.size % 2 == 1
        nums.sort()
        val mid = nums.size/2 // 6/2 = 2 [1,2,3,4,5,6]
        if(isOdd)  {
            if(nums[mid] == k) return 0L
            if(nums[mid] < k) {
                val minHeap = PriorityQueue<Int>()
                for(i in mid until nums.size) {
                    minHeap.add(nums[i])
                }
                return findMedianInMinHeap(minHeap, k)
            } else if(nums[mid] > k) {
                val maxHeap = PriorityQueue<Int>(){a, b -> b-a}
                for(i in 0 .. mid) {
                    maxHeap.add(nums[i])
                }
                return findMedianInMaxHeap(maxHeap, k)
            }
        } else if(!isOdd) {
            if(nums[mid-1] == k ||nums[mid] == k) return 0L
            if(k > nums[mid]) {
                val minHeap = PriorityQueue<Int>()
                for(i in mid until nums.size) {
                    minHeap.add(nums[i])
                }
                return findMedianInMinHeap(minHeap, k)
            } else {
                val maxHeap = PriorityQueue<Int>(){a, b -> b-a}
                for(i in 0 until mid) {
                    maxHeap.add(nums[i])
                }
                return findMedianInMaxHeap(maxHeap, k)
            }
        }

        return 0L

    }

    private fun findMedianInMinHeap(minHeap: PriorityQueue<Int>, k: Int): Long {
        if(minHeap.size == 1) {
            return Math.abs(minHeap.poll()-k).toLong()
        }
        var result = 0L

        while(minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            if(k == top) return result
            else {
                minHeap.add(top+1)
                result++
            }
        }
        return result
    }

    private fun findMedianInMaxHeap(maxHeap: PriorityQueue<Int>, k: Int): Long {
        if(maxHeap.size == 1) {
            return Math.abs(maxHeap.poll()-k).toLong()
        }
        var result = 0L

        while(maxHeap.isNotEmpty()) {
            val top = maxHeap.poll()
            if(k == top) return result
            else {
                maxHeap.add(top-1)
                result++
            }
        }
        return result
    }
}

fun main() {
    val medianEqualTok = MedianEqualTok()
    println(medianEqualTok.minOperationsToMakeMedianK(intArrayOf(1,2,3,4,5,6), 7))
    println(medianEqualTok.minOperationsToMakeMedianK(intArrayOf(1,2,3,4,5,6), 4))
    println(medianEqualTok.minOperationsToMakeMedianK(intArrayOf(2,5,6,8,5), 7))
    println(medianEqualTok.minOperationsToMakeMedianK(intArrayOf(2,5,6,8,5), 4))
}