package recursion

class MergeSort {

    private fun merge(arr: IntArray, i: Int, mid: Int, j: Int) {
        val tmp = IntArray(j - i + 1)
        var l = i
        var r = mid + 1
        var k = 0
        while (l <= mid && r <= j) {
            if (arr[l] > arr[r]) {
                tmp[k] = arr[r]
                r++
            }else {
                tmp[k] = arr[l]
                l++
            }
            k++
        }
        while (l <= mid) {
            tmp[k++] = arr[l++]
        }
        while (r <= j) {
            tmp[k++] = arr[r++]
        }
        l = i
        k = 0
        while (l <= j) {
            arr[l++] = tmp[k++]
        }
    }

    private fun sort(arr: IntArray, i: Int, j: Int) {
        if (i < j) {
            val mid = i + (j - i) / 2
            sort(arr, i, mid)
            sort(arr, mid+1, j)
            merge(arr, i, mid, j)
        }
    }

    fun mergeSort(arr: IntArray) {
        sort(arr, 0, arr.size - 1)
        println(arr.contentToString())
    }

}

fun main () {
    val v = MergeSort()
    v.mergeSort(intArrayOf(4, 2, 1))
}