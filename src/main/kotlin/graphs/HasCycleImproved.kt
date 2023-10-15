package graphs

/**
 * Three Conditions here
 * If numberOfElementsVisisted more then 1 and back to same element then a cycle
 * If numberOfElementsVisited is equal to array size break from array loop
 * return true if the currentIndex is equal to starting index
 */
fun hasSingleCycle2(array: List<Int>): Boolean {
    // Write your code here.
    val STARTING_INDX = 0
    var currentIndex = STARTING_INDX
    var numElementsVisited = 0
    while (numElementsVisited < array.size) {
        if (numElementsVisited > 0 && currentIndex == STARTING_INDX)
            return false
        numElementsVisited += 1
        currentIndex = calculateNextIndex(currentIndex, array[currentIndex],
            array.size)
    }
    return currentIndex == STARTING_INDX
}

fun calculateNextIndex(i: Int, ele: Int, arrSz: Int): Int {
    var j = (i+ele) % arrSz
    if (j < 0) {
        j += arrSz
    }
    return j
}

fun main() {
    hasSingleCycle2(arrayListOf(2, 3, 1, -4, -4, 2))
}