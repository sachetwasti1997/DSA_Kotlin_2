package recursion

typealias lls = ArrayList<List<String>>
typealias lch = ArrayList<CharArray>

class NQueens {

    private fun isSafe(row: Int, col: Int, board: lch, n:Int): Boolean {
        var r = row
        var c = col
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false
            r --
            c --
        }
        r = row
        c = col
        while (c >= 0) {
            if (board[r][c--] == 'Q') return false
        }
        r = row
        c = col
        while (c >= 0 && r < n) {
            if (board[r][c] == 'Q') return false
            r ++
            c --
        }
        return true
    }

    private fun solveRecursive(col:Int, res: lls, board: lch, n: Int) {
        if (col == n) {
            val b = board.map { it.joinToString("") }
            println(b)
            res.add(ArrayList(b))
            return
        }
        println(col)
        for (r in 0 ..< n) {
            if (isSafe(r, col, board, n)) {
                board[r][col] = 'Q'
                solveRecursive(col+1, res, board, n)
                board[r][col] = '.'
            }
        }
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val board = lch(n).apply {
            for (i in 0..<n)this.add(CharArray(n){'.'})
        }
        val res = lls()
        solveRecursive(0, res, board, n)
        return res
    }
}

fun main() {
    val n = NQueens()
    println(n.solveNQueens(4))
}