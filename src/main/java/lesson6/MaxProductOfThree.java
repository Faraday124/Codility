package lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
    private int solution(int[] A) {

        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        int negativeMax = A[0] * A[1] * A[A.length - 1];
        int positiveMax = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        return Math.max(negativeMax, positiveMax);
    }

    public static void main(String[] args) {
        MaxProductOfThree m = new MaxProductOfThree();
        int[] A = new int[]{-3, 1, 2, -2, 5, 6};
        System.out.println(m.solution(A));
    }
}
