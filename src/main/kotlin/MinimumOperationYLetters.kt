fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
    val arrayY = countElementInY(grid)
    val arrayOtherThanY = countElementInZ(grid)

    // (1,0) (1,2) (0,1)(0,2) (2,1)(2,0)
    val array = arrayOf(
        intArrayOf(1, 0), intArrayOf(1, 2),
        intArrayOf(0, 1), intArrayOf(0, 2),
        intArrayOf(2, 0), intArrayOf(2, 1)
    )

    var res = Integer.MAX_VALUE
    val yTotal = arrayY.sum()
    val zTotal = arrayOtherThanY.sum()

    for (i in 0 until array.size) {
        var changes = 0
        changes += yTotal - arrayY[array[i][0]]
        changes += zTotal - arrayOtherThanY[array[i][1]]
        res = Math.min(res, changes)
    }
    return res
}

fun countElementInY(grid: Array<IntArray>): IntArray {
    val size = grid.size
    val col = grid[0].size

    val midRow = size / 2
    val array = IntArray(3) { 0 }

    for (i in 0..midRow) {
        array[grid[i][i]] += 1
        if (col - 1 - i == i) continue
        array[grid[i][col - 1 - i]] += 1
    }

    for (i in midRow + 1 until size) {
        array[grid[i][col / 2]] += 1
    }
    return array
}

fun countElementInZ(grid: Array<IntArray>): IntArray {
    val size = grid.size
    val col = grid[0].size

    val array = IntArray(3) { 0 }

    for (i in 0 until size) {
        for (j in 0 until col) {
            array[grid[i][j]] += 1
        }
    }

    val prevArray = countElementInY(grid)

    array[0] = array[0] - prevArray[0]
    array[1] = array[1] - prevArray[1]
    array[2] = array[2] - prevArray[2]

    return array
}


fun main() {
    // [[1,2,2],[1,1,0],[0,1,0]]
    println(
        "Output: ${
            minimumOperationsToWriteY(
                arrayOf(
                    intArrayOf(1, 2, 2),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 0)
                )
            )
        }"
    )
}