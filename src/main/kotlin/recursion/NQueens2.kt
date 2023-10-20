package recursion

class NQueens2 {

    private fun isSafe(col: Int, row: Int, board: Array<CharArray>): Boolean {
        var c = col
        var r = row
        while (c >= 0 && r >= 0) {
            if (board[r][c] == 'Q') return false
            r --
            c --
        }
        r = row
        c = col
        while (c >=0) {
            if (board[r][c] == 'Q') return false
            c --
        }
        r = row
        c = col
        while (c >= 0 && r < board.size) {
            if (board[r][c] == 'Q') return false
            r++
            c--
        }
        return true
    }

    private fun dfs(col: Int, n: Int, board: Array<CharArray>): Int {
        if (col == n) {
            return 1
        }
        var calc = 0
        for (r in 0 ..< n) {
            if (isSafe(col, r, board)) {
                board[r][col] = 'Q'
                calc += dfs(col+1, n, board)
                board[r][col] = '.'
            }
        }
        return calc
    }

    fun totalNQueens(n: Int): Int {
        val board = Array(n) { CharArray(n) {'.'} }
        return dfs(0, n, board)
    }
}

fun main() {
    val nq = NQueens2()
    println(nq.totalNQueens(2))
}

