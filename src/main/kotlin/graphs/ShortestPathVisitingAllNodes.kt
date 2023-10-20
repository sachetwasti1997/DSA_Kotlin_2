package graphs

class ShortestPathVisitingAllNodes {

    fun dfsCalc() {}

    fun shortestPathLength(graph: Array<IntArray>): Int {
        val hs = HashSet<Int>().apply {  }
        hs.add(2)
        val v = hs.remove(hs.first())
        val i = 1
        println(i.shl(3))
        return 2
    }
}

fun main() {
    val s = ShortestPathVisitingAllNodes()
    s.shortestPathLength(arrayOf())
}