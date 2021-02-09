package lesson8;

import java.util.Arrays;

class Dominator {
    public int solution(int[] A) {
        if(A.length == 0) {
            return -1;
        }

        int[] copy = new int[A.length];
        System.arraycopy(A, 0, copy, 0, A.length);
        Arrays.sort(copy);

        int candidate = copy[A.length / 2];
        long count = Arrays.stream(A).boxed().filter(el -> el == candidate).count();

        int firstIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                firstIndex = i;
                break;
            }
        }
        return count > A.length / 2 ? firstIndex : -1;
    }

    public static void main(String[] args) {
        Dominator d = new Dominator();
        System.out.println(d.solution(new int[]{5, 5, 2, 3, 4, 5, 5}));
        System.out.println(d.solution(new int[]{1}));
        System.out.println(d.solution(new int[]{}));
    }
}

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].*/
