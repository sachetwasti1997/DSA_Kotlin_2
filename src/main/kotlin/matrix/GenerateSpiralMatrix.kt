package matrix

class GenerateSpiralMatrix {
    fun generateMatrix(n: Int): Array<IntArray> {
        var i = 1
        val res = Array(n){IntArray(n)}
        var top = 0
        var bottom = n
        var left = 0
        var right = n
        while (i <= n*n) {
            // iterate in the top row
            for (it in left ..< right){
                res[top][it] = i ++
            }
            top++
            //iterate in the right col
            for (it in top ..< bottom) {
                res[it][right - 1] = i ++
            }
            right--
            //iterate in the bottom row
            for (it in right-1 downTo  left) {
                res[bottom-1][it] = i++
            }
            bottom --
            //iterate in left col
            for (it in bottom-1 downTo top) {
                res[it][left] = i ++
            }
            left ++
        }
        res.forEach {
            println(it.contentToString())
        }
        return res
    }
}

fun main() {
    val g = GenerateSpiralMatrix()
    g.generateMatrix(1)
}