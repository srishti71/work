class RearrangeArray {
    fun rearrangeArray(nums: IntArray): IntArray {

        var k = 0
        var i = 0
        var j = 1
        while(k < nums.size) { // 28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31
            if(k%2 == 0 && nums[k] > 0) {
                k++
                i += 2
            } else if(k%2 == 1 && nums[k]<0) {
                k++
                j+=2
            } else if(k%2 ==0  && j < nums.size) {
                val temp = nums[k]
                nums[k] = nums[j]
                nums[j]=temp
                j += 2
            } else if(k%2 == 1 && i < nums.size){
                val temp = nums[k]
                nums[k] = nums[i]
                nums[i]=temp
                i += 2
            } else {
                k++
            }
        }
        return nums
    }
}

fun main() {
    val rearrangeArray = RearrangeArray()
    println(rearrangeArray.rearrangeArray(intArrayOf(28,-41,22,-8,46,-37,35,-9,18,-6,19,-26,-10,-37,-9,15,14,31)).map{println(it)})
//                                                                                           i   j
}