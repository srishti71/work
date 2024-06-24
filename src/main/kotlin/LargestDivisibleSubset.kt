import java.util.*

class LargestDivisibleSubset {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {

        nums.sort()
        val size = nums.size
        val dp = Array(size){mutableListOf<Int>()}
        var resLength =0
        var res = mutableListOf<Int>()

        for(i in 0 until size) {
            dp[i] = mutableListOf(nums[i])
            if(i ==0) {
                resLength = 1
                res = dp[i]
            }
        }

        for(i in size - 1 downTo 0) { // [1,2,4,6,8]

            for(j in i+1 until size) { //         [8]
                if(nums[j]%nums[i] == 0) {
                    if(dp[i].size < 1 + dp[j].size) {
                        val temp = mutableListOf<Int>()
                        temp.add(nums[i])
                        temp.addAll(dp[j])
                        dp[i] = temp
                        if(resLength < temp.size) {
                            resLength = temp.size
                            res = temp
                        }
                    }
                }
            }
        }
        return res

    }
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val arrayDeque = ArrayDeque<Int>()
    val output = IntArray(nums.size-k+1){0}

    for(i in 0 until nums.size){
        if(arrayDeque.isNotEmpty() && arrayDeque.peekFirst() == i -k) {
            arrayDeque.removeFirst()
        }

        while(arrayDeque.isNotEmpty() && nums[i] > nums[arrayDeque.peekLast()]) {
            arrayDeque.removeLast()
        }
        arrayDeque.offer(i)

        if(i + 1 >= k) {
            output[i-k+1] = nums[arrayDeque.peekFirst()]
        }
    }
    return output
}

fun main() {
//    val largestDivisibleSubset = LargestDivisibleSubset()
//    println(largestDivisibleSubset.largestDivisibleSubset(intArrayOf(3,4,16,8)))

}