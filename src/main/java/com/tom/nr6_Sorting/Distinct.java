package com.tom.nr6_Sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        int solution = new Solution().solution(A);
        System.out.println(solution);
    }

    public static class Solution {
        public int solution(int[] A) {
            Set<Integer> distinctSet = new HashSet<>();
            for (int i : A) {
                distinctSet.add(i);
            }
            return distinctSet.size();
        }
    }
}

