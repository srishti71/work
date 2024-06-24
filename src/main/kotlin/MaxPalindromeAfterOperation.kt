class MaxPalindromeAfterOperation {

    fun maxPalindromesAfterOperations(words: Array<String>): Int {
        words.sortBy { it.length }
        val map = mutableMapOf<Char, Int>()

        for (ele in words) {
            for (i in 0 until ele.length) {
                map[ele[i]] = map.getOrDefault(ele[i], 0) + 1
            }
        }

        var result = 0
        label@ for (ele in words) {
            val len = ele.length / 2

            for (i in 0 until len) {
                if (map.containsKey(ele[i])) {
                    val count = map[ele[i]]!!
                    if (count < 2) {
                        continue@label
                    } else if (count == 2)
                        map.remove(ele[i])
                    else map[ele[i]] = map.getOrDefault(ele[i], 0) - 2
                } else {
                    continue@label
                }
            }
            result++
        }
        return result
    }
}

fun main() {
    val words = arrayOf("abc", "ab")
    val maxPalindromeAfterOperation = MaxPalindromeAfterOperation()
    maxPalindromeAfterOperation.maxPalindromesAfterOperations(words)
}
/*
AACAABAACAABAACP
010120123456789

010120123456789

 */