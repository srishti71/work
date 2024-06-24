class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val booleanArray = BooleanArray(nums.size+1){false}

        for(i in nums) {
            booleanArray[i] = true
        }

        for(i in 0 until booleanArray.size) {
            if(!booleanArray[i]) return 0
        }
        return -1
    }
}
fun main() {
    val missingNumber = MissingNumber()
    missingNumber.missingNumber(intArrayOf(3,0,1))
}