package Lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Iwo on 22.02.2018.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {

        Map<Integer, Integer> counters = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int value = counters.get(A[i]) == null ? 0 : counters.get(A[i]);
            counters.put(A[i], ++value);
        }
        Optional<Map.Entry<Integer, Integer>> result = counters.entrySet().stream().filter(i -> i.getValue() % 2 != 0).findAny();
        return result.isPresent() ? result.get().getKey() : -1;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray r = new OddOccurrencesInArray();
        System.out.println(r.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(r.solution(new int[]{2, 2, 3, 3, 4}));
    }
}
