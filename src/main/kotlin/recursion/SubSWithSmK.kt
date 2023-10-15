package recursion

class SubSWithSmK {

    private fun find(i: Int, sum: Int, arr: IntArray, lst: ArrayList<Int>) {
        if (sum == 0) {
            println(lst)
            return
        }
        if (i == arr.size) return
        lst.add(arr[i])
        find(i+1, sum - arr[i], arr, lst)
        lst.removeAt(lst.size - 1)
        find(i+1, sum, arr, lst)
    }

    fun findSub(sum: Int, arr: IntArray) {
        find(0, sum, arr, ArrayList())
    }

}

fun main() {
    val s = SubSWithSmK()
    s.findSub(11, intArrayOf(1,2,1, 3, 4, 5, 7))
}