class MinSumValueDivide {
    fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
        val dp = Array(nums.size) { IntArray(andValues.size) { -1 } }
        return minimumValueSumUtil(nums, andValues, 0, 0, dp)
    }


    fun minimumValueSumUtil(nums: IntArray, andValues: IntArray, index: Int, index2: Int, dp: Array<IntArray>): Int {

        if (index == nums.size && index2 == andValues.size) {
            return 0
        } else if (index == nums.size) return Integer.MAX_VALUE

        if (dp[index][index2] != -1) return dp[index][index2]
        var curr = nums[index]

        var currResult = Integer.MAX_VALUE
        if (curr == andValues[index2]) {
            val result = minimumValueSumUtil(nums, andValues, index + 1, index2 + 1, dp)
            if (result != Integer.MAX_VALUE)
                currResult = Math.min(result + curr, currResult)
        }

        for (i in index + 1 until nums.size) {
            curr = curr and nums[i]
            if (curr == andValues[index2]) {
                val result = minimumValueSumUtil(nums, andValues, i + 1, index2 + 1, dp)
                if (result != Integer.MAX_VALUE)
                    currResult = Math.min(result + nums[i], currResult)
            }
        }

        dp[index][index2] = currResult
        return dp[index][index2]
    }

}

fun main() {
    val minSumValueDivide = MinSumValueDivide()
    println(minSumValueDivide.minimumValueSum(intArrayOf(2, 3, 5, 7, 7, 7, 5), intArrayOf(0, 7, 5)))
}