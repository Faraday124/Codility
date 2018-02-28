package Lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Iwo on 28.02.2018.
 */
public class MissingInteger {

    public static int solution(int[] A) {
        List<Integer> numbers = IntStream.of(A)
                .boxed()
                .filter(x -> x > 0)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() == 0) {
            return 1;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) != i + 1)
                return i + 1;
        }
        return numbers.size() + 1;
    }

    public static void main(String[] args) {
        MissingInteger i = new MissingInteger();
        System.out.println(i.solution(new int[]{1, 3, 6, 4, 1, 2}));
    }


}
/**
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */