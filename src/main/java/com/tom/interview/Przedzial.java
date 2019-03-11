package com.tom.interview;

import java.util.HashSet;
import java.util.Set;

public class Przedzial {

    public static void main(String[] args) {
        int[] A1 = {4, 6, 2, 2, 6, 6, 1};
        int solution1 = new Solution().solution2(A1);
        System.out.println(solution1);

        int[] A2 = {2, 1, 3, 2};
        int solution2 = new Solution().solution2(A2);
        System.out.println(solution2);

        int[] A3 = {6, 4, 6, 1, 2, 4};
        int solution3 = new Solution().solution2(A3);
        System.out.println(solution3);

        int[] A4 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        int solution4 = new Solution().solution2(A4);
        System.out.println(solution4);

        int[] A5 = {1, 2, 3, 3, 5, 6, 7, 8, 9, 10};
        int solution5 = new Solution().solution2(A5);
        System.out.println(solution5);
    }



    public static class Solution {
        public int solution(int[] A) {
            int N = A.length;
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i] == A[j])
                        result = Math.max(result, Math.abs(i - j));
                }
            }
            return result;
        }

        public int solution2(int[] A) {
            int result = 0;
            int[] positionOfFirstNumber = new int[A.length];
            for (int i = 0; i < A.length;  i++) {
                int value = A[i];
                // if positionOfFirstNumber[value] is equal to 0, the value hasn't been set yet
                if (positionOfFirstNumber[value - 1] == 0)
                    positionOfFirstNumber[value - 1] = i + 1;
                result = Math.max((i + 1) - positionOfFirstNumber[value - 1], result);
            }
            return result;
        }

    }
}

