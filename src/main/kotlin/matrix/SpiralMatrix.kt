package matrix

class SpiralMatrix {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val res = ArrayList<Int>()
            var left = 0
            var right = matrix[0].size
            var top = 0
            var bottom = matrix.size
            while (top < bottom && left < right) {
                // iterate the top row
                for (i in left ..< right) {
                    res.add(matrix[top][i])
                }
                top += 1
                // iterate the right column
                for (i in top ..< bottom) {
                    res.add(matrix[i][right - 1])
                }
                right -= 1

                if (top >= bottom || left >= right)
                    break

                // iterate the bottom row
                for (i in right - 1 downTo left) {
                    res.add(matrix[bottom - 1][i])
                }
                bottom -= 1
                // iterate the left column
                for (i in bottom - 1 downTo top) {
                    res.add(matrix[i][left])
                }
                left += 1
            }
            print(res)
            return res
        }
}

fun main() {
    val s = SpiralMatrix()
    s.spiralOrder(arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12)))
}