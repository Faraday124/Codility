package Lesson2;

import java.util.Arrays;

/**
 * Created by Iwo on 22.02.2018.
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {

        for (int i = 0; i < K; i++) {
            A = rotate(A);
        }
        return A;

    }

    public int[] rotate(int[] original) {
        int[] result = new int[original.length];
        System.arraycopy(original, 0, result, 0, original.length);
        for (int i = 0; i < original.length; i++) {
            if (i != original.length-1) {
                result[i+1] = original[i];
            } else {
                result[0] = original[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CyclicRotation r = new CyclicRotation();
        int[] x = new int[] { 7, 3, 4, 5 };
        int [] result = r.solution(x, 1);
        System.out.println(Arrays.toString(result));
    }

}
