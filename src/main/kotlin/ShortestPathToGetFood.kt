import java.util.*

class ShortestPathToGetFood {
    fun getFood(grid: Array<CharArray>): Int {
        val queue = LinkedList<IntArray>()
        val row = grid.size
        val col = grid[0].size

        val seen = mutableSetOf<Int>()
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == '*') {
                    queue.add(intArrayOf(i, j, 0))
                    break
                }
            }
        }

        val direction = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

        while (queue.isNotEmpty()) {
            val element = queue.poll()
            if (grid[element[0]][element[1]] == '#') return element[2]
            seen.add(element[0] * col + element[1])
            for (dir in direction) {
                val x = element[0] + dir[0]
                val y = element[1] + dir[1]
                if (x >= row || y >= col || x < 0 || y < 0) continue
                if (seen.contains(x * col + y)) continue
                queue.add(intArrayOf(x, y, element[2] + 1))
            }
        }

        return -1
    }
}

fun main() {

}