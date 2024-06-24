package substring

class MinWindowSliding {
    fun minWindow(s: String, t: String): String {
        var res = Integer.MAX_VALUE
        val map = Array<Int>(128){0}
        for(str in t) {
            map[str.toInt()] += 1
        }
        var counter = t.length
        var start = 0
        var startIndex = 0
        for(i in 0 until s.length) {

            if(map[s[i].toInt()] > 0) {
                counter-- // 2

            }
            map[s[i].toInt()]--

            while(counter == 0) {
                if(res > i - start + 1) {
                    res = i - start + 1
                    startIndex = start
                }

                map[s[start].toInt()] ++
                if(map[s[start].toInt()] > 0)  {
                    counter++
                }

                start++
            }
        }

        if(res == Integer.MAX_VALUE) return ""
        return s.substring(startIndex, startIndex + res)
    }
}

fun main() {
    val minWindowSliding = MinWindowSliding()
    minWindowSliding.minWindow("ADOBECODEBANC", "ABC")
}