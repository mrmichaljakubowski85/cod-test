package com.tom.nr5_PrefixSums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String s = "CAGCCTA";
//        String s = "GGGGGGGGGGGGGGGG";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] solution = new Solution().solution(s, P, Q);
        System.out.println(Arrays.toString(solution));
    }

    public static class Solution {
        public int[] solution(String S, int[] P, int[] Q) {
            int len = S.length();
            int[][] arr = new int[len + 1][3];
            int queryLen = P.length;
            int[] result = new int[queryLen];

            for (int i = 0; i < len; i++) {
                switch (S.charAt(i)) {
                    case 'A':
                        arr[i + 1][0]++;
                        break;
                    case 'C':
                        arr[i + 1][1]++;
                        break;
                    case 'G':
                        arr[i + 1][2]++;
                        break;
                }
                if (i + 1 < len) {
                    System.arraycopy(arr[i + 1], 0, arr[i + 2], 0, 3);
                }
            }

            for (int i = 0; i < queryLen; i++) {
                int p = P[i];
                int q = Q[i];
                for (int j = 0; j < 3; j++) {
                    if (arr[q + 1][j] - arr[p][j] > 0) {
                        result[i] = j + 1;
                        break;
                    }
                    //memory saving: we can omit one row: new int[len + 1] [3] instead of new int[len + 1] [4]
                    result[i] = 4;
                }
            }
            return result;
        }
    }
}


