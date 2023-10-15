package recursion

class reverse_array {

    private fun reverse_recurse(i: Int, j: Int, arr: IntArray) {
        if (i >= j) return
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
        reverse_recurse(i+1, j-1, arr)
    }

    private fun single_reverse(i: Int, arr: IntArray) {
        if (i >= arr.size/2) return
        val tmp = arr[i]
        arr[i] = arr[arr.size-i-1]
        arr[arr.size-i-1] = tmp
        single_reverse(i+1, arr)
    }

    fun reverse(arr: IntArray): IntArray {
        single_reverse(0, arr)
        return arr
    }
}

fun main() {
    val arr = intArrayOf(1,2,3,4,5)
    val rev = reverse_array()
    println(rev.reverse(arr).contentToString())
}