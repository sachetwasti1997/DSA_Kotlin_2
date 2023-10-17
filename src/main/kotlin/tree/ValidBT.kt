package tree

import java.util.LinkedList

typealias ia = IntArray
class ValidBT {
    fun validateBinaryTreeNodes(n: Int, leftChild: ia, rightChild: ia): Boolean {
        val allNodes = (leftChild+rightChild).toHashSet()
        var rt = -1
        for (i in 0..<n) {
            if (!allNodes.contains(i)) {
                if (rt == -1) rt = i
                else return false
            }
        }
        if (rt == -1) return false
        allNodes.clear()
        val q = LinkedList<Int>()
        q.add(rt)
        var inx = 0
        while (!q.isEmpty()) {
            val nd = q.poll()
            if (allNodes.contains(nd)) return false
            if (leftChild[inx] != -1) q.add(leftChild[inx])
            if (rightChild[inx] != -1) q.add(rightChild[inx])
        }
        return true
    }
}

fun main() {
    val s = ValidBT()
    s.validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1))
}