package graphs

import recursion.ali
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

typealias alali = Array<ArrayList<Int>>

class ParallelCourses3 {

    private fun dfs(i: Int, gr: alali, indg: IntArray, visited: IntArray, stk: Stack<IntArray>) {
        visited[i] = 0
        for (nd in gr[i]) {
            if (visited[nd] == -1) {
                dfs(nd, gr, indg, visited, stk)
            }
        }
        stk.add(intArrayOf(i, indg[i]))
    }

    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val indg = IntArray(n){0}
         val gr = Array<ArrayList<Int>>(n) { ArrayList() }

        for (i in relations) {
            gr[i[0] - 1].add(i[1] - 1)
            indg[i[0] - 1] ++
        }
        val visited = IntArray(n){-1}
        val topSort = Stack<IntArray>()
        for (i in 0..<n) {
            if (visited[i] == -1) {
                dfs(i, gr, indg, visited, topSort)
            }
        }
        var timeUsed = 0
        var ind = Int.MAX_VALUE
        var mx = 0
        topSort.forEach {
            if (ind == it[1]) {
                mx = max(mx, time[it[0]])
            } else {
                timeUsed += mx
                ind = it[1]
                mx = time[it[0]]
            }
        }
        return timeUsed + mx
    }
}

fun main() {
    val top = ParallelCourses3()
    println(top.minimumTime(5, arrayOf(intArrayOf(1,5), intArrayOf(2,5),
        intArrayOf(3,5), intArrayOf(3,4), intArrayOf(4,5)), intArrayOf(1,2,3,4,5)))
//    println(top.minimumTime(3, arrayOf(intArrayOf(1,3), intArrayOf(2,3),
//    ), intArrayOf(3,2,5)))
}