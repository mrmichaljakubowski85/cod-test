package com.tom.test;

public class Nr1 {

    public static void main(String[] args) {

        int solution1 = new Solution().solution(10);
        System.out.println(solution1);


        int solution2 = new Solution().solution(123456);
        System.out.println(solution2);


        int solution3 = new Solution().solution(0);
        System.out.println(solution3);

        int solution4 = new Solution().solution(9);
        System.out.println(solution4);

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

    }
}

