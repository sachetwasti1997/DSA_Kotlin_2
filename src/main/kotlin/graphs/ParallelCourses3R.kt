package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class ParallelCourses3R {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val indg = IntArray(n){0}
        val gr = Array<ArrayList<Int>>(n) { ArrayList() }
        for (i in relations) {
            gr[i[1] - 1].add(i[0] - 1)
            indg[i[0] - 1]++
        }
        val q = LinkedList<Int>()
        val visited = HashSet<Int>()
        for (i in 0..<n) {
            if (indg[i] == 0) {
                q.add(i)
                visited.add(i)
            }
        }
        var sz = q.size
        var totalTime = 0
        while (!q.isEmpty()) {
            var mxTm = 0
            while (sz > 0) {
                val tmp = q.poll()
                if (mxTm < time[tmp]) mxTm = time[tmp]
                for (i in gr[tmp]) {
                    if (!visited.contains(i)) {
                        visited.add(i)
                        q.add(i)
                    }
                }
                sz --
            }
            totalTime += mxTm
            sz = q.size
        }
        return totalTime
    }
}

fun main() {
    val p = ParallelCourses3R()
    val t = p.minimumTime(5, arrayOf(intArrayOf(1,5), intArrayOf(2,5), intArrayOf(3,5), intArrayOf(3,4), intArrayOf(4,5)),
        intArrayOf(1,2,3,4,5))
    println(t)
}