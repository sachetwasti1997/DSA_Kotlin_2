package recursion

import java.lang.Integer.max

typealias ia = IntArray
typealias aLi = ArrayList<Int>
class ConstrainedSubSum {

    private fun calculateSubSetSum (nums: ia, skpLn: Int, indx: Int): Int {
        if (indx >= nums.size) {
            return 0
        }
        var sm = nums[indx]
        for (k in indx+1 .. indx+skpLn) {
            if (k >= nums.size) break
            sm = max(sm +calculateSubSetSum(nums,skpLn, k), calculateSubSetSum(nums,skpLn, k))
        }
        return sm
    }

    fun constrainedSubsetSum (nums: IntArray, k: Int): Int {
        var maxV = Int.MIN_VALUE
        for (i in nums) {
            if (maxV < i) maxV = i
        }
        if (maxV <= 0) return maxV
        return calculateSubSetSum(nums,k, 0)
    }
}

fun main () {
    val v = ConstrainedSubSum()
    val u = v.constrainedSubsetSum(intArrayOf(10,-2,-10,-5,20), 2)
    println(u)
}
