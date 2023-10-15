package recursion

/**
 * We need to make some observations about which element is replaced
 * when we start from a left or right
 * head element is changed whenever we start from left, or there are
 * odd number of elements
 */
fun lastRemaining(n: Int): Int {
    var head = 1
    var step = 1
    var left = true
    var remaining = n
    while (remaining > 0) {
        if (left || remaining % 2 == 1) {
            head += step
        }
        left = !left
        remaining /= 2
        step *= 2
    }
    return head
}