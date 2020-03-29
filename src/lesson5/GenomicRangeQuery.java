package lesson5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    private static final Map<Character, Integer> impactFactors;

    static {
        impactFactors = new HashMap<>();
        impactFactors.put('A', 1);
        impactFactors.put('C', 2);
        impactFactors.put('G', 3);
        impactFactors.put('T', 4);
    }

    public int[] solution(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];
        int[][] occurrences = new int[S.length()][impactFactors.size()];

        addNewOccurrence(S, occurrences, 0);

        for (int i = 1; i < occurrences.length; i++) {
            addNewOccurrence(S, occurrences, i);
            sumPreviousOccurrences(occurrences, i);
        }

        for (int i = 0; i < P.length; i++) {
            int indexFrom = P[i] - 1;
            int indexTo = Q[i];

            for (int j = 0; j < impactFactors.size(); j++) {
                int occurrenceFrom = indexFrom < 0 ? 0 : occurrences[indexFrom][j];

                if (occurrences[indexTo][j] - occurrenceFrom > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    private void sumPreviousOccurrences(int[][] occurrences, int i) {
        for (int j = 0; j < impactFactors.size(); j++) {
            occurrences[i][j] += occurrences[i - 1][j];
        }
    }

    private void addNewOccurrence(String S, int[][] occurrences, int i) {
        if (!impactFactors.containsKey(S.charAt(i))) {
            return;
        }
        int impactFactor = impactFactors.get(S.charAt(i)) - 1;
        occurrences[i][impactFactor] = 1;
    }

    public static void main(String[] args) {
        GenomicRangeQuery g = new GenomicRangeQuery();
        int[] P = new int[3];
        int[] Q = new int[3];

        P[0] = 2;
        P[1] = 5;
        P[2] = 0;

        Q[0] = 4;
        Q[1] = 5;
        Q[2] = 6;

        System.out.println(Arrays.toString(g.solution("CAGCCTA", P, Q)));
        System.out.println(Arrays.toString(g.solution("C", new int[1], new int[1])));
    }
}

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor,
 * which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of
 * nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that: P[0] = 2    Q[0] = 4 P[1] = 5    Q[1] = 5 P[2] = 0    Q[2] = 6
 *
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2. The part between positions 5 and 5 contains a
 * single nucleotide T, whose impact factor is 4, so the answer is 4. The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is
 * 1, so the answer is 1.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers
 * to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that: P[0] = 2    Q[0] = 4 P[1] = 5    Q[1] = 5 P[2] = 0    Q[2] = 6
 *
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000]; M is an integer within the range [1..50,000]; each element of arrays P, Q is an integer within the range [0..N − 1]; P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
