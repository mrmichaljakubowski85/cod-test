package com.tom.nr3_TimeComplexity;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

    public static void main(String[] args) {
        int[] A1 = {2, 3, 1, 5};
        int solution1 = new Solution().solution(A1);
        System.out.println(solution1);

        int[] A2 = {};
        int solution2 = new Solution().solution(A2);
        System.out.println(solution2);
    }



    public static class Solution {
        public int solution(int[] A) {
            Set<Integer> valueSet = new HashSet<>();
            for (int i = 1; i <= A.length + 1; i++) {
                valueSet.add(i);
            }
            for (int i : A) {
                valueSet.remove(i);
            }
            return (int) valueSet.toArray()[0];
        }

        public int solution2(int[] A) {
            int N = A.length;
            long sum = ((long) (1 + (N + 1)) ) * (N + 1) / 2;
            for (int i : A) {
                sum -= i;
            }
            return (int) sum;
        }
    }
}

