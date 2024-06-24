class LongestPalindrome {
    fun longestPalindrome(words: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }

        var res = 0
        for (ele in words) {
            val reverse = ele.reversed()
            if (map.containsKey(ele) && map.containsKey(reverse)) {
                if (ele == reverse && map[ele]!! > 1) {
                    res += map[ele]!! / 2 * 2
                } else if (ele != reverse) {
                    val count = Math.min(map[ele]!!, map[reverse]!!)
                    map.remove(reverse)
                    map.remove(ele)
                    res += ele.length * count * 2
                }
            }
        }
        var palindrome = 0
        for (ele in words) {
            if (ele == ele.reversed()) {
                palindrome = Math.max(palindrome, ele.length)
            }
        }

        return res + palindrome
    }
}

fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    val map = mutableMapOf<Int, MutableList<Int>>()
    val size = nums.size
    val sumArray = LongArray(size) { 0L }
    for (i in nums.indices) {
        val list = map.getOrDefault(nums[i], mutableListOf<Int>())
        list.add(i)
        map[nums[i]] = list
        if (i == 0) {
            sumArray[i] = nums[i].toLong()
        } else {
            sumArray[i] = (sumArray[i - 1] + nums[i]).toLong()
        }
    }

    var res = Integer.MIN_VALUE.toLong()

    for (i in nums.indices) {
        val key1 = nums[i] + k
        if (map.containsKey(key1)) {
            val sum = getMaxSum(map[key1]!!, i, sumArray)
            res = Math.max(res, sum)
        }

//        val key2 = nums[i]-k
//        if (map.containsKey(key2)) {
//            val sum = getMaxSum(map[key2]!!, i, sumArray)
//            res = Math.max(res, sum)
//        }
    }
    println(res)
    return res
}

fun getMaxSum(list: MutableList<Int>, index: Int, sumArray: LongArray): Long {

    var res = Integer.MIN_VALUE.toLong()
    for (ele in list) {
        val first = if (ele < index) ele else index
        val second = if (ele > index) ele else index

        if (first == 0) {
            res = Math.max(res, sumArray[second])
        } else {
            val sum = sumArray[second] - sumArray[first - 1]
            res = Math.max(res, sum)
        }
    }
    return res
}

fun numberOfPairs(points: Array<IntArray>): Int {
    val map = mutableSetOf<String>()
    var res = 0
    val comparator = Comparator<IntArray> { a, b ->  if(a[0] == b[0]) b[1] - a[1] else a[0] - b[0] }
    points.sortWith(comparator)
    for (ele in points) {
        map.add("${ele[0]}-${ele[1]}")
    }

    //
    // (2,6) (6,2)
    // 2,2 3,2
    // 2,3
    // 2,4
    // 2,5
    for (i in points.indices) { // [ [2,6], [4,4], [6,2],]
        for (j in i + 1 until points.size) { //

//            if(points[i][0] > points[j][0] || points[i][1] < points[j][1]) continue
            var canBeHappy = true

            if (points[i][0] > points[j][0] || points[j][1] > points[i][1]) continue

            label@for (p in points[i][0]..points[j][0]) { //  (2,6) [6,2]
                for (q in points[j][1]..points[i][1]) {
                    if ((p == points[i][0] && q == points[i][1]) || (p == points[j][0] && q == points[j][1]))
                        continue
                    else if (map.contains("$p-$q")) {
                        canBeHappy = false
                        break@label
                    }
                }
            }

            if (canBeHappy) res++
        }
    }
    println(res)
    return res
}

fun triangleType(nums: IntArray): String {
    if (nums[0] == nums[1] && nums[1] == nums[2]) {
        return "equilateral"
    } else if ((nums[0] == nums[1] && nums[1] != nums[2]) || (nums[0] == nums[2] && nums[1] != nums[2]) || (nums[0] != nums[1] && nums[1] == nums[2])) {
        return "isosceles"
    } else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) {
        return "scalene"
    } else return "none"
}

fun main() {
    numberOfPairs(arrayOf(intArrayOf(6, 2), intArrayOf(4, 4), intArrayOf(2, 6)))
    numberOfPairs(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3)))
    numberOfPairs(arrayOf(intArrayOf(3, 1), intArrayOf(1, 3), intArrayOf(1, 1)))
//    maximumSubarraySum(intArrayOf(-1, -2, -3, -4), 2)
//    maximumSubarraySum(intArrayOf(1,2,3,4,5,6), 1)

}