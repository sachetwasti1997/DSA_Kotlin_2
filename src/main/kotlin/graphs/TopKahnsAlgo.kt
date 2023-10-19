package graphs

import java.util.LinkedList

class TopKahnsAlgo {
    fun topSort(rl: Array<IntArray>, n: Int): List<Int> {
        val gr = Array<ArrayList<Int>>(n) { ArrayList() }
        val indg = IntArray(n) {0}
        for (i in rl) {
            gr[i[0]].add(i[1])
            indg[i[1]] += 1
        }
        val q = LinkedList<Int>().apply {
            for (i in indg.indices) {
                if (indg[i] == 0) this.add(i)
            }
        }
        var sz = q.size
        val res = ArrayList<Int>()
        while (!q.isEmpty()) {
            while (sz > 0) {
                val tmp = q.poll()
                res.add(tmp)
                for (i in gr[tmp]) {
                    indg[i] --
                    if (indg[i] == 0) {
                        q.add(i)
                    }
                }
                sz--
            }
            sz = q.size
        }
        return res
    }
}

fun main() {
    val t = TopKahnsAlgo()
    t.topSort(arrayOf(intArrayOf(5, 0), intArrayOf(4, 0), intArrayOf(4, 1),
        intArrayOf(3, 1), intArrayOf(2, 3), intArrayOf(5, 2)), 6)
}