package dynamic_programming

import java.util.Arrays
import kotlin.math.min

class NumWaysToStayInSamePos {

    val mod: Int = 1_000_000_007

    private fun findWays(steps:Int, pos: Int, arrLn: Int, dp: Array<LongArray>): Long {
        if (pos < 0 || pos >= arrLn) return 0
        if (steps == 0 && pos == 0) return 1
        if (steps <= 0 && pos != 0) return 0
        if (dp[steps][pos] != -1L) return dp[steps][pos]
        var tmp:Long = 0
        tmp += findWays(steps - 1, pos - 1, arrLn, dp)
        tmp += findWays(steps - 1, pos, arrLn, dp)
        tmp += findWays(steps - 1, pos+1, arrLn, dp)
        dp[steps][pos] = ( tmp  % mod )
        return dp[steps][pos]
    }

    fun numWays(steps: Int, arrLen: Int): Int {
        val dp = Array(steps + 1) {LongArray(min(steps/2 + 1, arrLen)) {-1} }
        findWays(steps, 0, arrLen, dp)
        print(dp.forEach {
            println(it.contentToString())
        })
        return (dp[steps][0] % mod).toInt()
    }

}

fun main () {
    val s = NumWaysToStayInSamePos()
    var top = 0
    var bottom = 2
    if (!(top < bottom)) {}
    println(s.numWays(2, 4))
}