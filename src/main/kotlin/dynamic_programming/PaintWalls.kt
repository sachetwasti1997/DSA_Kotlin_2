package dynamic_programming

import kotlin.math.min

//fun paintWalls(cost: IntArray, time: IntArray): Int {\
//    val dp = HashMap<Pair<Int, Int>, Int>()
//    fun find_time(i: Int, remaining: Int): Int {
//        if (remaining <= 0) return 0
//        if (i == cost.size) return Int.MAX_VALUE;
//        if (dp[Pair(i, remaining)] != null) {
//            return dp[Pair(i, remaining)]!!
//        }
//        val inc = cost[i] + find_time(i+1, remaining - 1 - time[i])
//        val exc = find_time(i+1, remaining)
//        dp[Pair(i, remaining)] = min(inc, exc)
//        return dp[Pair(i, remaining)]!!
//    }
//    return find_time(0, cost.size)
//}
//
//fun main() {
//    val x = paintWalls(intArrayOf(2,3,4,2), intArrayOf(1,1,1,1))
//    print(x)
//}