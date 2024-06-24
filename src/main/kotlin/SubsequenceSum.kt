class SubsequenceSum {

    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        var res = Integer.MIN_VALUE

        for (i in 0 until nums.size) {
            if (arrayDeque.isNotEmpty() && arrayDeque.first().second < i - k) {
                arrayDeque.removeFirst()
            }
            val newsum = Math.max(nums[i] + if (arrayDeque.isNotEmpty()) arrayDeque.first().first else 0, nums[i])
            while (arrayDeque.isNotEmpty() && arrayDeque.last().first < newsum) {
                arrayDeque.removeLast()
            }
            res = Math.max(res, newsum)
            arrayDeque.add(Pair(newsum, i))
        }
        println(res)
        return res
    }
}

fun main() {
    val subsequenceSum = SubsequenceSum()
    subsequenceSum.constrainedSubsetSum(intArrayOf(10, 2, -10, 5, 20), 2)
    subsequenceSum.constrainedSubsetSum(intArrayOf(-1,-2,-3), 1)
    subsequenceSum.constrainedSubsetSum(intArrayOf(10,-2,-10,-5,20), 2)
}
// nums = [10,2,-10,5,20], k = 2
// 12,1
// 17