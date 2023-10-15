package recursion

class QuickSort {

    private fun swap(i: Int, j: Int, arr: IntArray) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    private fun pivot(low: Int, high: Int, arr: IntArray): Int {
        var i = low
        var j = high
        while (i < j) {
            while (arr[i] <= arr[low] && i < high) { i++ }
            while (arr[j] > arr[low] && j > low) {j--}
            if (i < j) swap(i, j, arr)
        }
        if (low < j) swap(low, j, arr)
        return j
    }

    private fun sortRec(low: Int, high: Int, arr: IntArray) {
        if (low < high) {
            val pivot = pivot(low, high, arr)
            sortRec(low, pivot-1, arr)
            sortRec(pivot+1, high, arr)
        }
    }

    fun sort(arr: IntArray) {
        sortRec(0, arr.size-1, arr)
        println(arr.contentToString())
    }

}

fun main() {
    val q = QuickSort()
    q.sort(intArrayOf(4, 4, 2, 1, 5, 3, 7))
}