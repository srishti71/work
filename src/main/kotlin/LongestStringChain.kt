class LongestStringChain {
    fun longestStrChain(words: Array<String>): Int {
        val map = mutableMapOf<Int, MutableSet<Int>>()
        words.sortBy { it.length }
        words.forEach {
            println(it)
        }

        for (i in words.indices) {
            val size = words[i].length
            val list = map.getOrDefault(size, mutableSetOf<Int>())
            list.add(i)
            map[size] = list
        }

        val size = words.size
        val dp = IntArray(size) { 1 }
        var res = 0
        for (i in words.indices) {
            if (words[i].length == 1) {
                continue
            } else {
                val list = map[words[i].length - 1]
                list?.let {
                    for (ele in it) {
                        if (isPredecessor(ele, i, words)) {
                            dp[i] = Math.max(dp[i], dp[ele] + 1)
                        }
                    }

                }
            }

            res = Math.max(res, dp[i])
        }
        return res
    }

    fun isPredecessor(small: Int, big: Int, words: Array<String>): Boolean {
        var i = 0
        var j = 0
        while (i < words[small].length && j < words[big].length) {
            if (words[big][j] == words[small][i]) {
                i++
                j++
            } else {
                j++
            }
        }
        return i == words[small].length
    }
}

fun main() {
    val longestStringChain = LongestStringChain()
    longestStringChain.longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"))
}