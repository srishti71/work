import java.util.*

class Competition {

    fun minOperations(k: Int): Int {

        // If double any element:  currentElement,  remains - cuurent operation+1
        // if increment by 1: currentElement + 1, remains - 1
        if (k <= 1) return 0

        val queue = LinkedList<IntArray>()

        queue.add(intArrayOf(k - 1, 1, 0))
        while (queue.isNotEmpty()) {
            val element = queue.poll()
            if (element[0] - 1 <= 0 || element[0] - element[1] <= 0) return element[2] + 1
            queue.add(intArrayOf(element[0] - 1, element[1] + 1, element[2] + 1))
            queue.add(intArrayOf(element[0] - element[1], element[1], element[2] + 1))
        }

        return 0
    }
}