import kotlin.math.pow

class SeqDigit {
    fun sequentialDigits(low: Int, high: Int): List<Int> {

        val highDigit = getNumberOfDigit(high) // 3
        val lowDigit = getNumberOfDigit(low)
        val lowFirst = getFirst(low) // 1
        val highFirst = high / 10.0.pow(lowDigit-1).toInt() // 3

        val list = mutableListOf<Int>()
        for (i in lowFirst..highFirst) { //1
            var res = 0 // 1
            var j = 0
            var k = i // 1
            for (p in 0 until highDigit) {
                res = res * 10 + k++
                if (res >= low && res <= high) list.add(res)
            }
        }

        return list
    }
    // 1 * 10 1 +2

    // 12
    // 12*

    fun getNumberOfDigit(low: Int): Int { // 300
        var num = low
        var count = 0
        while (num > 0) {
            num = num / 10 // 0
            count++ // 3
        }
        return count
    }

    fun getFirst(low: Int): Int { // 100
        var num = low
        var res = 0
        while (num >= 10) { // 243
            num = num / 10 // 1
        }
        return num
    }
}

fun main() {
    val seqDigit = SeqDigit()
    seqDigit.sequentialDigits(100, 300)
}