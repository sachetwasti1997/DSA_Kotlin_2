package recursion

class FibonacciRec {
    private fun rec_fibonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return rec_fibonacci(n-1) + rec_fibonacci(n-2)
    }

    fun calculate_fib(n: Int): Int {
        return rec_fibonacci(n)
    }
}

fun main() {
    val f = FibonacciRec()
    println(f.calculate_fib(6))
}