package maths

import java.util.IntSummaryStatistics
import kotlin.math.max

fun integerBreak(n: Int): Int {
    val dp = HashMap<Int, Int>()
    dp[1] = 1
    return breakToDp(n, n, dp)
}

fun breakToDp(num: Int, org: Int, dp: HashMap<Int, Int>): Int {
    dp[num]?.let { return it }
    dp[num] = if (num == org) 0 else num
    for (i in 1 .. num) {
        val v = breakToDp(i, org, dp) * breakToDp(num - i, org, dp)
        dp[num] = max(dp[num]!!, v)
    }
    return dp[num]!!
}