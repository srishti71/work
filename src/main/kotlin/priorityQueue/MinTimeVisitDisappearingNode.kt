package priorityQueue

import java.util.*

class MinTimeVisitDisappearingNode {
    fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {

        val priorityQueue = PriorityQueue<IntArray>() { a: IntArray, b: IntArray ->
            if (disappear[a[0]] == disappear[b[0]]) a[1] - b[1] else
                disappear[a[0]] - disappear[b[0]]
        }

        val set = mutableSetOf<Int>()

        val map = initializeMap(edges)
        val result = IntArray(n) { -1 }
        priorityQueue.add(intArrayOf(0, 0))

        while (priorityQueue.isNotEmpty()) {
            val element = priorityQueue.poll()

            if (set.contains(element[0])) continue
            else {
                set.add(element[0])
                if (element[1] <= disappear[element[0]]) {
                    result[element[0]] = element[1]
                    if (map.containsKey(element[0])) {
                        for (ele in map[element[0]]!!) {
                            if (!set.contains(ele.first)) {
                                priorityQueue.add(intArrayOf(ele.first, ele.second + element[1]))
                            }
                        }
                    }
                }
            }
        }
        return result
    }

    fun initializeMap(edges: Array<IntArray>): Map<Int, List<Pair<Int, Int>>> {

        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (edge in edges) {

            val list = map.getOrDefault(edge[0], mutableListOf<Pair<Int, Int>>())
            list.add(Pair(edge[1], edge[2]))

            map[edge[0]] = list

            val list1 = map.getOrDefault(edge[1], mutableListOf<Pair<Int, Int>>())
            list1.add(Pair(edge[0], edge[2]))

            map[edge[1]] = list1
        }

        return map
    }
}

fun main() {
    val minTimeVisitDisappearingNode = MinTimeVisitDisappearingNode()
    // n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
    val result = minTimeVisitDisappearingNode.minimumTime(
        3,
        // [[0,1,2],[1,2,1],[0,2,4]]
        arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(0, 2, 4)),
        intArrayOf(1, 3, 5)
    )

    result.map { println(it) }
}