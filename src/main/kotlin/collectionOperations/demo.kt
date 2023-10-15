package collectionOperations

class demo {
    fun setOp() {
        val numbers = setOf(1, 2, 3, 4)
        val n2 = hashSetOf<Int>()
        println(numbers.map { it * 10 })
        // modifies and returns a new array
        println(numbers.map { if (it == 3) it * 100 else it * 5 })
        println(numbers)
    }
}

fun main() {
    val d = demo()
    d.setOp()
}