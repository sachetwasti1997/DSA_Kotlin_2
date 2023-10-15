package recursion

class Permutations {

    private fun createPermutations(visited: HashSet<Int>, nums: IntArray,
                                   tmp: ArrayList<Int>, res: ArrayList<ArrayList<Int>>) {
        if (visited.size == nums.size) {
            res.add(ArrayList(tmp))
            return
        }
        for (i in nums.indices) {
            if (visited.contains(i)) continue
            visited.add(i)
            tmp.add(nums[i])
            createPermutations(visited, nums, tmp, res)
            visited.remove(i)
            tmp.removeAt(tmp.size - 1)
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val visited_index = HashSet<Int>(nums.size)
        val res = ArrayList<ArrayList<Int>>()
        createPermutations(visited_index, nums, ArrayList(), res)
        return res
    }

}

fun main() {
    val p = Permutations()
    println(p.permute(intArrayOf(0,1)))
}