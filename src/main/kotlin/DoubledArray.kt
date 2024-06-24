import java.util.*

class DoubledArray {
    fun findOriginalArray(changed: IntArray): IntArray {
        val size = changed.size
        if (size % 2 == 1) return intArrayOf()

        val list = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until size) {
            map[changed[i]] = map.getOrDefault(changed[i], 0) + 1
        }

        val keys = map.keys.toMutableList()
        keys.sort()

        if (map.containsKey(0) && map[0]!! % 2 == 0) {
            var count = map[0]!! / 2
            while (count > 0) {
                list.add(0)
                count--
            }
        }

        map.remove(0)
        println(map)
        for (ele in keys) {
            if (!map.containsKey(ele)) continue

            val doubleEle = ele * 2
            if (map.containsKey(doubleEle)) {
                val doubleEleFreq = map[doubleEle]!!
                val eleFreq = map[ele]!!
                var counter = Math.min(doubleEleFreq, eleFreq)
                val count = counter// 1
                while (counter > 0) {
                    list.add(ele)
                    counter--
                }
                if (doubleEleFreq == count) {
                    map.remove(doubleEle)
                } else {
                    map[doubleEle] = doubleEleFreq - count
                }

                if (eleFreq == count) {
                    map.remove(ele)
                } else {
                    map[ele] = eleFreq - count
                }
            }
        }
        println(list)
        return if (list.size == size / 2) list.toIntArray() else intArrayOf()
    }
}

fun main() {
    val doubledArray = DoubledArray()
//    doubledArray.findOriginalArray(intArrayOf(2, 1, 2, 4, 2, 4))
//    doubledArray.findOriginalArray(intArrayOf(1, 2, 3, 2, 4, 6, 2, 4, 6, 4, 8, 12))
    doubledArray.findOriginalArray(intArrayOf(4, 4, 16, 20, 8, 8, 2, 10))
}