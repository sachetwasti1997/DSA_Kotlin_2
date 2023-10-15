package recursion

class CombinationSum2 {

    private fun findComb(indx: Int, arr: IntArray, target: Int, tmpList: ArrayList<Int>,
                         res: ArrayList<ArrayList<Int>>) {
        if (target == 0) {
            res.add(ArrayList(tmpList))
            return
        }
        if (target < 0) {return}
        if (indx >= arr.size) {return}

        tmpList.add(arr[indx])
        findComb(indx+1, arr, target-arr[indx], tmpList, res)
        tmpList.removeAt(tmpList.size-1)
        var i = indx
        while (i + 1 < arr.size && arr[i] == arr[i+1]) {i++}
        findComb(i+1, arr, target, tmpList, res)
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        candidates.sort()
        findComb(0, candidates, target, ArrayList(), res)
        return res
    }
}

fun main() {
    val cs2 = CombinationSum2()
    println(cs2.combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
}