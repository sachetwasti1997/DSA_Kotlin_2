package general_algo

class NextPermutation {

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    fun nextPermutation(nums: IntArray): Unit {
        var inx = -1
        val n = nums.size
        for (i in n-2 downTo 0) {
            if (nums[i+1] > nums[i]){
                inx = i
                break
            }
        }
        if (inx == -1) {
            nums.reverse()
            return
        }
        var min = Int.MAX_VALUE
        var minInx = inx
        for (i in n-1 downTo inx - 1) {
            if (nums[i] > nums[inx] && min > nums[i]) {
                min = nums[i]
                minInx = i
            }
        }
        swap(nums, inx, minInx)
        nums.sort(inx+1, n)
    }
}

fun main() {
    val n = NextPermutation()
    val arr = intArrayOf(1,2)
    n.nextPermutation(arr)
    println(arr.contentToString())
}