package com.tom.nr10_PrimeAndCompositeNumbers;

import java.util.HashSet;
import java.util.Set;

public class CountFactors {

    public static void main(String[] args) {
        int solution = new Solution().solution(24);
        System.out.println(solution);

        int solution2 = new Solution().solution2(24);
        System.out.println(solution2);

    }

    public static class Solution {

        //100% - incrementing i is faster than multiplying i*i in every step
        public int solution(int N) {
            if (N == 1)
                return 1;
            int result = 0;
            int sqrN = (int) Math.ceil(Math.sqrt(N));
            int i = 1;
            while (i < sqrN) {
                if (N % i == 0)
                    result += 2;
                i++;
            }
            if (i * i == N)
                result++;
            return result;
        }

        //92%
        public int solution2(int N) {
            if (N == 1)
                return 1;
            int result = 0;
            int i = 1;

            while (i * i < N) {
                if (N % i == 0)
                    result += 2;
                i++;
            }
            if (i * i == N)
                result++;
            return result;
        }

    }
}

