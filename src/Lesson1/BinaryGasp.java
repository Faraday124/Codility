package Lesson1;

/**
 * Created by Iwo on 22.02.2018.
 */
public class BinaryGasp {

    public int solution(int N) {

        String binary = Integer.toBinaryString(N);
        int result = 0;
        int binaryGap = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (result < binaryGap) {
                    result = binaryGap;
                }
                binaryGap = 0;

            } else if (binary.charAt(i) == '0') {
                binaryGap++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryGasp b = new BinaryGasp();
        System.out.println(b.solution(1041));
    }
}
