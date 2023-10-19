package graphs

import java.util.Stack

class TopologicalOrdering {

    private fun dfsTopologicalSort(nd: Int, rl: HashMap<Int, ArrayList<Int>>,
                           stk: Stack<Int>, visited: HashSet<Int>) {
        visited.add(nd)
        for (i in rl[nd].orEmpty()) {
            if (!visited.contains(i))
                dfsTopologicalSort(i, rl, stk, visited)
        }
        stk.add(nd)
    }
    fun topologicalOrder(rl: Array<IntArray>) {
        val gr = HashMap<Int, ArrayList<Int>>().apply {
            for (i in rl) {
                if (this[i[0]] == null) {
                    this[i[0]] = ArrayList()
                }
                this[i[0]]!!.add(i[1])
            }
        }
        val visited = HashSet<Int>()
        val stk = Stack<Int>()
        for (i in gr.keys) {
            println(i)
            if (!visited.contains(i)) {
                dfsTopologicalSort(i, gr, stk, visited)
            }
        }
        println(stk)
    }
}

fun main() {
    val t = TopologicalOrdering()
    t.topologicalOrder(arrayOf(intArrayOf(5, 0), intArrayOf(4, 0), intArrayOf(4, 1),
        intArrayOf(3, 1), intArrayOf(2, 3), intArrayOf(5, 2)))
}

