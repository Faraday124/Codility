package lesson6

private fun solution(A: IntArray): Int {

    if(A.size-3 < 0)
        return -1

    A.sort()
    val negativeMax = A[0] * A[1] * A.last()
    val positiveMax = A.last() * A[A.size-2] * A[A.size-3]

    return negativeMax.coerceAtLeast(positiveMax)
}

fun main() {
    val A = intArrayOf(-3, 1, 2, -2, 5, 6)
    println(solution(A))
}
