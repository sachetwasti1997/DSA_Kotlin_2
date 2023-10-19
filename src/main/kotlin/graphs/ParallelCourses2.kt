package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class ParallelCourses2 {
    fun minNumberOfSemesters(n: Int, relations: Array<IntArray>, k: Int): Int {
        val indg = mutableSetOf<Int>()
        val gr = mutableMapOf<Int, ArrayList<Int>>().apply {
            for (i in relations) {
                if (!this.containsKey(i[0]))
                    this[i[0]] = ArrayList()
                this[i[0]]!!.add(i[1])
                indg.add(i[1])
            }
        }
        val q = LinkedList<Int>()
        for (i in 1..n) {
            if (!indg.contains(i)) {
                q.add(i)
            }
        }
        var sz = q.size
        var sz_pntr = 0
        var nm_semesters = 0
        val visited = HashSet<Int>(n)
        while (!q.isEmpty()) {
            if (sz_pntr == 0)sz_pntr = sz
            var k_pntr = k
            while (sz_pntr > 0 && k_pntr > 0) {
                sz_pntr--
                k_pntr--
                val nd = q.poll()
                for (i in gr[nd].orEmpty()) {
                    if (!visited.contains(i)) {
                        visited.add(i)
                        q.add(i)
                    }
                }
            }
            nm_semesters++
            sz = q.size
        }
        return nm_semesters
    }
}

fun main() {
    val p = ParallelCourses2()
    val p1 =p.minNumberOfSemesters(5, arrayOf(intArrayOf(1,5), intArrayOf(1,3), intArrayOf(1,2), intArrayOf(4,2)
    ,intArrayOf(4,5), intArrayOf(2,5), intArrayOf(1,4), intArrayOf(4,3), intArrayOf(3,5), intArrayOf(3,2)), 3)
//    val p1 = p.minNumberOfSemesters(4, arrayOf(intArrayOf(2,1), intArrayOf(3,1), intArrayOf(1,4)), 2)
    println(p1)
}