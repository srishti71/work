class NumberOfSubArrayThatMatch {
    fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int {
        val size = nums.size
        val newNums = IntArray(size-1){0}

        for(i in 1 until size) {
            newNums[i-1] = if(nums[i] == nums[i-1]) 0 else if(nums[i] > nums[i-1]) 1 else -1
        }

        val lps = preprocess(pattern)

        var i = 0
        var j = 0
        var res = 0
        while(i < size-1) {
            if(newNums[i] == pattern[j]) {
                i++
                j++
            }
            if(j == pattern.size) {
                res++
                j = lps[j-1]
            }
            if(i < size-1 && newNums[i] != pattern[j]) {
                if(j == 0) {
                    i = i+1
                } else
                    j = lps[j-1]
            }
        }
        return res
    }

    fun preprocess(pattern: IntArray): IntArray {
        val size = pattern.size
        val array = IntArray(size){0}

        var len = 0
        var i = 1

        while(i <size) {
            if(pattern[i] == pattern[len]) {
                len += 1
                array[i] = len
                i++
            } else {
                if(len == 0) {
                    i = i+1
                }
                else len = array[len-1]
            }
        }
        return array

    }
}

fun main() {
    val numberOfSubArrayThatMatch = NumberOfSubArrayThatMatch()
    numberOfSubArrayThatMatch.countMatchingSubarrays(intArrayOf(1,4,4,1,3,5,5,3), intArrayOf(1,0,-1))
}