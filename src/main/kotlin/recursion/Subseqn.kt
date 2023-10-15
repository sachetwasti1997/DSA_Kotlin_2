package recursion

class Subseqn {
    fun rec_printSubSeq(i: Int, array: IntArray, lst: ArrayList<Int>
                        , res: ArrayList<ArrayList<Int>>) {
        if (i >= array.size) {
            res.add(ArrayList(lst))
            return
        }

        lst.add(array[i])
        rec_printSubSeq(i+1, array, lst, res)
        lst.removeAt(lst.size-1)
        var indx = i
        while (indx + 1 < array.size && array[indx] == array[indx+1]) {indx++}
        rec_printSubSeq(indx+1, array, lst, res)
    }

    fun subsetsWithDup(nums: IntArray):List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        rec_printSubSeq(0, nums, ArrayList(), res)
        return res
    }
}

fun main() {
    val s = Subseqn()
    println(s.subsetsWithDup(intArrayOf(1,2,2)))
}