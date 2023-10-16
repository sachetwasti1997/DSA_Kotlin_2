package recursion
typealias li = List<Int>
typealias ali = ArrayList<Int>
class PascalTriangle {
    fun getRow(rowIndex: Int): li {
        if (rowIndex == 0) return arrayListOf(1)
        val res = arrayListOf(1,1)
        for (i in 2..rowIndex) {
            res.add(1)
            for (j in res.size - 2 downTo  1) {
                res[j] = res[j-1] + res[j]
            }
        }
        return res
    }
}

fun main () {
    val p = PascalTriangle()
    println(p.getRow(4))
}