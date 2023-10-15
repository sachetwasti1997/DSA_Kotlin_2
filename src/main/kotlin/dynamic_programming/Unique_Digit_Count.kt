package dynamic_programming

fun countNumbersWithUniqueDigits(n: Int): Int {
    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return 10
    }
    var sm = 10
    for(n1 in 2..n) {
        var i = 0
        var pr = 1
        var digits = 9
        while (i < n1) {
            if (i > 1) digits--
            pr *= digits
            i++
        }
        sm += pr
    }
    return sm
}

fun main () {
    val m = countNumbersWithUniqueDigits(3)
    println(m)
}