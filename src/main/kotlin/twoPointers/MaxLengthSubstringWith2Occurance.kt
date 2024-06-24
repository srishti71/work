package twoPointers

class MaxLengthSubstringWith2Occurance {
    fun maximumLengthSubstring(s: String): Int {

        var res = 0
        val array = IntArray(26) { 0 }
        var j = 0
        for (i in 0 until s.length) { // dcfdddccb
            val index = s[i] - 'a'
            array[index] += 1 // [0,0,1,2,0,1]
            if (array[index] > 2) {
                while (j < i && s[j] != s[i]) {
                    array[s[j]-'a'] -= 1
                    j++
                }
                j++ // 1
                array[index] -= 1
            }
            res = Math.max(res, i - j + 1)
        }

        return res
    }
}

fun main() {
    val maxLengthSubstringWith2Occurance = MaxLengthSubstringWith2Occurance()
    println(maxLengthSubstringWith2Occurance.maximumLengthSubstring("dcfdddccb"))
}