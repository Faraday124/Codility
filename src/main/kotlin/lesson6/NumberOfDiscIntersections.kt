package lesson6

/** First iteration O(N**2) and score 75% */
private fun solution(A: IntArray): Int {

    var totalSum = 0

    A.indices.forEach { i ->
        val currentIndexFrom = i - A[i]
        val currentIndexTo = i + A[i]

        ((i + 1) until A.size).forEach { j ->
            val nextIndexFrom = j - A[j]
            val nextIndexTo = j + A[j]
            val isIntersection = (currentIndexTo >= nextIndexFrom) ||
                    (nextIndexFrom <= currentIndexFrom && nextIndexTo >= currentIndexTo) ||
                    (currentIndexFrom <= currentIndexFrom && currentIndexTo >= nextIndexTo)
            if (isIntersection) {
                totalSum++
            }
        }
    }
    return totalSum
}

/** Optimized solution O(N*log(N)) and score 100% */
private fun solution2(A: IntArray): Int {

    var totalSum = 0
    val circleEvents = mutableListOf<Pair<Long, Boolean>>()

    A.indices.forEach { i ->
        circleEvents.add(Pair(i - A[i].toLong(), true))
        circleEvents.add(Pair(i + A[i].toLong(), false))
    }

    val sortedEvents = circleEvents.sortedWith(
            compareBy(Pair<Long, Boolean>::first, { !it.second })
    )

    var activeCircles = 0

    sortedEvents.forEach { event ->
        if (event.second) {
            totalSum += activeCircles
            activeCircles++
        } else {
            activeCircles--
        }
        if(totalSum > 10E6) {
            return -1
        }
    }

    return totalSum
}

fun main() {
    val A = intArrayOf(1, 5, 2, 1, 4, 0)
    println("First solution: ${solution(A)}")
    println("Second solution: ${solution2(A)}")
}


/**
We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:
A[0] = 1
A[1] = 5
A[2] = 2
A[3] = 1
A[4] = 4
A[5] = 0

There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
 */
