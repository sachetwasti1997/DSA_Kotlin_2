package recursion

import java.lang.StringBuilder

class CreateKthPermutation {
    fun getPermutation(n: Int, k: Int): String {
        if (n == 1) {return "1"}
        val arr = IntArray(n) { it+1 }
        val res = ArrayList<String>()
        var d = 0
        dfsGeneratePermutations(0, n, k, d, arr, res)
        println(res)
        return res[k-1]
    }

    private fun dfsGeneratePermutations(indx: Int, n: Int, k: Int, d: Int, arr: IntArray, res: ArrayList<String>) {
        if (d == k + 1) {
            return
        }
        if (indx >= n) return
        res.add(arr.joinToString (""))
        val d1 = d + 1
        for (i in 0 ..< n) {
            swap(indx, i, arr)
            dfsGeneratePermutations(indx+1, n, k, d1, arr, res)
            swap(indx, i, arr)
        }
    }

    private fun swap(i: Int, j: Int, arr: IntArray) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}

fun main() {
    val v = CreateKthPermutation()
    println(v.getPermutation(9, 9))
}