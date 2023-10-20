package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.max

class ParallelCourses3R {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val indg = IntArray(n){0}
        val gr = Array<ArrayList<Int>>(n) { ArrayList() }
        for (i in relations) {
            gr[i[0] - 1].add(i[1] - 1)
            indg[i[1] - 1]++
        }
        val q = LinkedList<Int>()
        val tm = time + intArrayOf(0)
        for (i in 0..<n) {
            if (indg[i] == 0) {
                q.add(i)
            }
        }
        var sz = q.size
        var it = 0
        val mx = IntArray(n){0}
        val res = ArrayList<Int>()
        while (!q.isEmpty()) {
            while (sz > 0) {
                val tmp = q.poll()
                res.add(tmp)
                mx[it] = max(mx[it], time[tmp])
                for (i in gr[tmp]) {
                    indg[i] --
                    if (indg[i] == 0) {
                        q.add(i)
                    }
                }
                sz --
            }
            it++
            sz = q.size
        }
        println(res.max())
        return mx.sum()
    }
}

fun main() {
    val p = ParallelCourses3R()
//    val t = p.minimumTime(9, arrayOf(intArrayOf(2,7), intArrayOf(2,6), intArrayOf(3,6), intArrayOf(4,6), intArrayOf(7,6),
//        intArrayOf(2,1), intArrayOf(3,1), intArrayOf(4,1), intArrayOf(6,1), intArrayOf(7,1),
//        intArrayOf(3,8), intArrayOf(5,8), intArrayOf(7,8), intArrayOf(1,9), intArrayOf(2,9),
//        intArrayOf(6,9), intArrayOf(7,9)),
//        intArrayOf(9,5,9,5,8,7,7,8,4))
    val t = p.minimumTime(5, arrayOf(intArrayOf(1,5), intArrayOf(2,5),
        intArrayOf(3,5), intArrayOf(3,4), intArrayOf(4,5)), intArrayOf(1,2,3,4,5))
    println(t)
}