package string

class BackSpaceCharacterCompare {

    fun backspaceCompare(s: String, t: String): Boolean {
        val dq = ArrayDeque<Char>()
        for (i in s) {
            if (i == '#' && !dq.isEmpty()) {
                dq.removeFirst()
            }else if (i != '#') {
                dq.addFirst(i)
            }
        }
        val dq2 = ArrayDeque<Char>()
        for (i in t) {
            if (i == '#' && !dq2.isEmpty()) {
                dq2.removeFirst()
            }else if (i != '#') {
                dq2.addFirst(i)
            }
        }
        while (!dq.isEmpty() && !dq2.isEmpty()) {
            if (dq.removeFirst() != dq2.removeFirst()) return false
        }
        return dq.isEmpty() && dq2.isEmpty()
    }

}

fun main() {
    val b = BackSpaceCharacterCompare()
    b.backspaceCompare("y#fo##f", "y#f#o##f")
}