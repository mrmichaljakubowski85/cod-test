package com.tom.nr6_Sorting;

import java.util.Arrays;


public class Triangle {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        int solution = new Solution().solution(A);
        System.out.println(solution);
    }

    public static class Solution {
        public int solution(int[] A) {
            if (A.length < 3)
                return 0;
            Arrays.sort(A);
            int len = A.length - 2;
            for (int i = 0; i < len; i++) {
                if ((long) A[i] + (long) A[i + 1] > A[i + 2])
                    return 1;
            }
            return 0;
        }
    }
}
