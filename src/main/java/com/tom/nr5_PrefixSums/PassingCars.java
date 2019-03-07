package com.tom.nr5_PrefixSums;

import java.util.Arrays;

public class PassingCars {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1, 0, 1};
        int solution = new Solution().solution(A);
        System.out.println(solution);
    }

    public static class Solution {
        public int solution(int[] A) {
            int result = 0;
            int len = A.length;

            int numberOneCounter = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (A[i] == 1) {
                    numberOneCounter++;
                } else {
                    result += numberOneCounter;
                    if (result > 1000000000)
                        return -1;
                }
            }

            return result;
        }
    }
}

