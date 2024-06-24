class ArrayDoublePairs {
    fun canReorderDoubled(arr: IntArray): Boolean {
        val list = arr.toMutableList()
        list.sort()
        println(list)

        for (i in 0 until arr.size / 2) { // -4,-2,2,4
            if (list[2 * i] < 0) { //
                if (list[2 * i] != 2 * list[2 * i + 1]) {
                    return false
                }
            } else {
                if (list[2 * i]  != list[2 * i + 1]*2) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val arrayDoubledPairs = ArrayDoublePairs()
    arrayDoubledPairs.canReorderDoubled(intArrayOf(4, -2, 2, -4))
}