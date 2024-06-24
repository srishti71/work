package priorityQueue

import java.util.PriorityQueue

class MeetingRoom {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val intervalList = intervals.sortedWith(compareBy({ it[0] }, { it[1] }))
        val priorityQueue = PriorityQueue<Int>(){a: Int, b: Int -> a-b}
        var rooms = 0
        for(ele in intervalList) { // [[0,30],[5,10],[15,20]]
            if(priorityQueue.isNotEmpty() && ele[0] > priorityQueue.peek()) {
                priorityQueue.poll()
            } else {
                rooms++
            }
            priorityQueue.add(ele[1]) // [10,30]
        }
        return rooms
    }
}