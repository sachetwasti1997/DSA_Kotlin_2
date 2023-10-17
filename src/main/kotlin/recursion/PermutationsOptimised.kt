package recursion

class PermutationsOptimised {

    private fun swap(i: Int, j: Int, arr: IntArray) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    private fun createPermutations(indx: Int, arr: IntArray, res: ArrayList<ArrayList<Int>>) {
        if (indx == arr.size) {
            res.add(ArrayList(arr.toList()))
            return
        }
        for (i in indx..<arr.size) {
            swap(indx, i, arr)
            createPermutations(indx+1, arr, res)
            swap(indx, i, arr)
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        createPermutations(0, nums, res)
        return res
    }

}

fun main() {
    val p = PermutationsOptimised()
    p.permute(intArrayOf(1, 2, 3))
}