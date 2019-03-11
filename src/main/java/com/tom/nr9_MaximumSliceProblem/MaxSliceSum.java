package com.tom.nr9_MaximumSliceProblem;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class MaxSliceSum {
    public static void main(String[] args) {
        int[] A = {5, -7, 3, 5, -2, 4, -1};
        int solution = new Solution().solution(A);
        System.out.println(solution);

    }
    public static class Solution {

        //O(n) complexity, 100% points
        public int solution(int[] A) {
            int N = A.length;
            int maxEnding = A[0];
            int maxSlice = A[0];

            for (int i = 1; i < N; i++) {
                maxEnding = Math.max(A[i], maxEnding + A[i]);
                maxSlice = Math.max(maxSlice, maxEnding);

            }
            return maxSlice;
        }

        //O(n^2) complexity
        public int solution2(int[] A) {
            int N = A.length;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int p = i; p < N; p++) {
                    sum += A[p];
                    result = Math.max(sum, result);
                }
            }
            return result;
        }

        //O(n^3) complexity
        public int solution3(int[] A) {
            int N = A.length;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int p = i; p < N; p++) {
                    int sum = 0;
                    for (int k = i; k < p + 1; k++) {
                        sum += A[k];
                    }
                    result = Math.max(result, sum);
                }
            }
            return result;
        }
    }
}
