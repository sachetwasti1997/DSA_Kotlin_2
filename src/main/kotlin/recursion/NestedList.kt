package recursion

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  abstract class NestedInteger {
      // Constructor initializes an empty nested list.
      constructor()
 
      // Constructor initializes a single integer.
      constructor(value: Int)
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      abstract fun isInteger(): Boolean
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      abstract fun getInteger(): Int?
 
      // Set this NestedInteger to hold a single integer.
      abstract fun setInteger(value: Int): Unit
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      abstract fun add(ni: NestedInteger): Unit
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      abstract fun getList(): List<NestedInteger>?
 }


class NestedIterator(nestedList: List<NestedInteger>) {

    private val res: ArrayList<Int> = ArrayList()
    private var indx = 0

    init {
        for (i in nestedList) {
            calculateIntger(i)
        }
    }

    private fun calculateIntger(i: NestedInteger) {
        if (i.isInteger()) {
            res.add(i.getInteger()!!)
            return
        }
        for (nl in i.getList().orEmpty()) {
            calculateIntger(nl)
        }
    }

    fun next(): Int {
        val r = res[indx]
        indx ++
        return r
    }

    fun hasNext(): Boolean {
        return indx < res.size
    }
}