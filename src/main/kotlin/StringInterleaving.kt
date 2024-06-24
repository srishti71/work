class StringInterleaving {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len3 != len1 + len2) return false
        var j = 0
        var k = 0
        for (i in 0 until s3.length) { // "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
            if (j < len1 && s3[i] == s1[j]) {
                j++
            } else if (k < len2 && s3[i] == s2[k]) {
                k++
            } else return false
        }
        return true
    }
}

fun frequencySort(s: String): String {
    val map = mutableMapOf<Char, Int>()

    for(i in 0 until s.length) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
    }

    val keys = map.keys.sortedByDescending { map[it] }
    val sb = StringBuilder()
    for(ele in keys) {
        var count = map[ele]!!
        while(count > 0) {
            sb.append(ele)
            count--
        }
    }
    return sb.toString()
}

fun main() {
    val stringInterleaving = StringInterleaving()
    stringInterleaving.isInterleave("aabcc", "dbbca", "aadbbcbcac")
}