package priorityQueue

import java.util.*
import kotlin.collections.ArrayList


// Definition for an Interval.
class Interval {
    var start: Int = 0
    var end: Int = 0

    constructor(_start: Int, _end: Int) {
        start = _start
        end = _end
    }
}


class EmployeeFree {
    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val start = PriorityQueue<Int>()
        val end = PriorityQueue<Int>()

        for (ele in schedule) {
            for (i in ele.indices) {
                start.add(ele[i].start)
                end.add(ele[i].end)
            }
        }
        val result = mutableListOf<Interval>()
        while (start.isNotEmpty()) {
            if (start.peek() < end.peek()) {
                start.poll()
            } else if (start.peek() > end.peek()) {
                var newStart = end.poll()
                while (end.isNotEmpty() && start.peek() > end.peek()) {
                    newStart = end.poll()
                }
                result.add(Interval(newStart, start.peek()))
                println("interval ${newStart} ${start.peek()}")
            } else {
                start.poll()
                end.poll()
            }
        }
        return ArrayList(result)
    }
}

fun main() {
    val input = arrayListOf(
        arrayListOf(
            Interval(7, 24), Interval(29, 33), Interval(45, 57),
            Interval(66, 69), Interval(94, 99)
        ),
        arrayListOf(
            Interval(6, 24), Interval(43, 49),
            Interval(56, 59),
            Interval(61, 75),
            Interval(80, 81)
        ),
        arrayListOf(
            Interval(5, 16), Interval(18, 26),
            Interval(33, 36),
            Interval(39, 57),
            Interval(65, 74)
        ),
        arrayListOf(
            Interval(9, 16), Interval(27, 35),
            Interval(40, 55),
            Interval(68, 71),
            Interval(78, 81)
        ), arrayListOf(
            Interval(0, 25),
            Interval(29, 31),
            Interval(40, 47),
            Interval(57, 87),
            Interval(91, 94)
        )
    )
    val employeeFree = EmployeeFree()
    employeeFree.employeeFreeTime(input)

}