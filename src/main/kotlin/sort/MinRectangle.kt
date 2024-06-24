package sort

class MinRectangle {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        val comparator = Comparator { o1: IntArray, o2: IntArray ->
            return@Comparator if(o1[0] == o2[0]) o1[1]- o2[1] else o1[0] - o2[0]
        }

        points.sortWith(comparator)

        var lowX = -1
        var highY = -1
        var rectangle = 1
        val size = points.size

        for (i in 0 until size) {
            if (i == 0) {
                lowX = points[i][0] // 1
                highY = points[i][1] // 2
            } else if (points[i][0] - lowX <= w) {
                highY = Math.max(highY, points[i][1])
            } else {
                rectangle++
                lowX = points[i][0]
                highY = points[i][1]
            }
        }
        return rectangle
    }


}

fun main() {
//    [1,2] [2,3]

    val minRectangle = MinRectangle()
    println(minRectangle.minRectanglesToCoverPoints(arrayOf(intArrayOf(1,7), intArrayOf(4,4)), 1))
}