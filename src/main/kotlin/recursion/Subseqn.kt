package recursion

class Subseqn {
    fun rec_printSubSeq(i: Int, array: IntArray, lst: ArrayList<Int>) {
        if (i >= array.size) {
            println(lst)
            return
        }
        lst.add(array[i])
        rec_printSubSeq(i+1, array, lst)
        lst.removeAt(lst.size-1)
        rec_printSubSeq(i+1, array, lst)
    }

    fun printSubSeq(arr: IntArray) {
        rec_printSubSeq(0, arr, ArrayList())
    }
}

fun main() {
    val s = Subseqn()
    s.printSubSeq(intArrayOf(1,2,3))
}