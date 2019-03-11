package com.tom.test;

import java.util.Deque;
import java.util.LinkedList;

public class Nr1 {

    public static void main(String[] args) {

        int solution1 = new Solution().solution2(10);
        System.out.println(solution1);


        int solution2 = new Solution().solution2(123456);
        System.out.println(solution2);



        int solution3 = new Solution().solution2(0);
        System.out.println(solution3);

        int solution4 = new Solution().solution2(913);
        System.out.println(solution4);

        int solution5 = new Solution().solution2(4710);
        System.out.println(solution5);

    }



    public static class Solution {
        public int solution(int A) {
//            if (A <= 9)
//                return A;
            String s = String.valueOf(A);
            int i = 0;
            int q = s.length() - 1;
            StringBuilder sb = new StringBuilder();
            while ( i < q ) {
                sb.append(s.charAt(i)).append(s.charAt(q));
                i++;
                q--;
            }
            if (i == q) {
                sb.append(s.charAt(i));
            }
            return Integer.valueOf(sb.toString());
        }

        public int solution2(int A) {
            Deque<Short> digits = new LinkedList<>();
            if (A == 0)
                return 0;
            while (A > 0) {
                short digit = (short) (A % 10);
                digits.add(digit);
                A /= 10;
            }
            int result = 0;
            int numberOfDigits = digits.size();
            while (digits.size() > 1) {
                short first = digits.removeLast();
                result += first * powerOfTen(numberOfDigits - 1);
                numberOfDigits--;
                short last = digits.remove();
                result += last * powerOfTen(numberOfDigits - 1);
                numberOfDigits--;
            }
            if (!digits.isEmpty())
                result += digits.remove();
            return result;
        }

        public static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        public static int powerOfTen(int pow) {
            return POWERS_OF_10[pow];
        }
    }
}

