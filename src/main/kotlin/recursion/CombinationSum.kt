package recursion

class CombinationSum {

    private fun findSm(indx: Int, arr: IntArray, target: Int,
                       tmpList: ArrayList<Int>, resList: ArrayList<ArrayList<Int>>) {
        if (target == 0) {
            resList.add(ArrayList(tmpList))
            return
        }
        if (target < 0) {return}
        if (indx >= arr.size) {return}

        tmpList.add(arr[indx])
        findSm(indx, arr, target - arr[indx], tmpList, resList)
        tmpList.removeAt(tmpList.size-1)
        findSm(indx+1, arr, target, tmpList, resList)
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        findSm(0, candidates, target, ArrayList(), res)
        return res
    }
}

fun main() {
    val cs = CombinationSum()
    val r = cs.combinationSum(intArrayOf(2,3,6,7), 7)
    println(r)
}