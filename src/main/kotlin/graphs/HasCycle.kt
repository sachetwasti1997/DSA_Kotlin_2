package graphs

/**
 * Steps followed here
 * Convert the jumps array to index the current element points to
 * Creating a visited array and marking each points as not visited
 * start from an index and go to the next index from array created in first step
 * and mark the visited array
 * break out of loop if currentIndex is equal to starting index or visiting already visited element
 * if currentIndex is not startingIndex then return flase
 * if not all array elements are visited return false
 * else true
 */
fun hasSingleCycle(array: List<Int>): Boolean {
    // Write your code here.
    val lst = MutableList(array.size){0}
    for (i in array.indices) {
        var j = i + array[i]
        j = (j%array.size)
        if (j < 0) {
            j += array.size
        }
        lst[i] = j
    }
    val visited = MutableList(array.size){false}
    visited[0] = true
    var i = lst[0];
    while (i != 0) {
        if (visited[i]) break
        visited[i] = true
        i = lst[i]
    }
    if (i != 0) return false;
    for (visit in visited) {
        if (!visit) return false
    }
    return true
}