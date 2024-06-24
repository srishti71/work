class MaxFrequentId {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val map = mutableMapOf<Int, Long>()
        var maxElement = 0
        var maxValue = 0L
        val size = nums.size
        val array = LongArray(size) { 0L }

        for (i in 0 until nums.size) {
            if (freq[i] < 0 && maxElement == nums[i]) {
                map[nums[i]] = map.getOrDefault(nums[i], 0) + freq[i]
                maxElement = recalculateMaxElement(map)
                maxValue = map[maxElement]!!
            } else {
                map[nums[i]] = map.getOrDefault(nums[i], 0) + freq[i]
                if (maxValue < map[nums[i]]!!) {
                    maxValue = map[nums[i]]!!
                    maxElement = nums[i]
                }
            }
            array[i] = maxValue
        }
        array.map { println(it) }
        return array
    }

    fun recalculateMaxElement(map: MutableMap<Int, Long>): Int {
        return map.keys.sortedByDescending { map[it] }[0]
    }
}

fun main() {
    val maxFrequentId = MaxFrequentId()
    maxFrequentId.mostFrequentIDs(intArrayOf(5, 5, 3), intArrayOf(2, -2, 1))
}