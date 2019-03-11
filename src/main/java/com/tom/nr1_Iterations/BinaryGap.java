package com.tom.nr1_Iterations;

import java.util.stream.IntStream;

public class BinaryGap {

    public static void main(String[] args) {
        IntStream.of(9, 529, 20, 15, 32).forEach(value -> {
                    int solution = new Solution().solution(value);
                    System.out.println(solution);
                }
        );
    }

    public static class Solution {
        public int solution(int N) {
            int maxGap = 0;
            int currentGap = 0;
            //skip the zeros at least significant bits
            while (N > 0 && N % 2 == 0) {
                N /= 2;
            }
            while (N > 0) {
                if (N % 2 == 0) {
                    currentGap++;
                } else if (currentGap > 0) {
                    maxGap = Math.max(currentGap, maxGap);
                    currentGap = 0;
                }
                N /= 2;
            }
            return maxGap;
        }

    }
}
