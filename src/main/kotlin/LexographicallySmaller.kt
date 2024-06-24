class LexographicallySmaller {
    fun getSmallestString(s: String, k: Int): String {
        var  rem = k
        if (rem == 0) return s
        val result = StringBuilder()
        var i = 0
        while (i < s.length) {
            if(s[i] == 'a') {
                result.append((s[i]))
                i++
                continue
            }
            if (rem == 0) break
            val cost = Math.min(s[i] - 'a', 'z' - s[i] + 1)
            if (cost > rem) {
                result.append((s[i] - rem).toChar())
                i++
                break
            } else {
                result.append('a')
                rem -= cost
            }
            i++
        }

        for (j in i until s.length) {
            result.append(s[j])
        }
        return result.toString()
    }
}

fun main() {
    val lexographicallySmaller = LexographicallySmaller()
    println(lexographicallySmaller.getSmallestString("zbbz", 3))
    println(lexographicallySmaller.getSmallestString("xaxcd", 4))
    println(lexographicallySmaller.getSmallestString("lol", 3))
    println(lexographicallySmaller.getSmallestString("popppo", 25))
}