package com.tom.test;

import java.util.Arrays;

public class Nr2 {

    public static void main(String[] args) {
        int[] A1 = {6, 1, 4, 6, 3, 2, 7, 4};
        int solution1 = new Solution().solution(A1, 3, 2);
        System.out.println(solution1);

        System.out.println("----------");

        int[] A2 = {5, 19, 15, 2};
        int solution2 = new Solution().solution(A2, 2, 2);
        System.out.println(solution2);


    }


    public static class Solution {
        public int solution(int[] A, int K, int L) {
            int len = A.length;
            if (K + L > len)
                return -1;

            int[] prefixSum = new int[len + 1];

            //prefixSum[0] = 0;
            for (int i = 1; i < len + 1; i++) {
                prefixSum[i] = prefixSum[i - 1] + A[i - 1];
            }

            System.out.println(Arrays.toString(A));
            System.out.println(Arrays.toString(prefixSum));

            int result = -1;

            int i = 0;
            int j = K - 1;
            while (j < len) {

                int x = 0;
                int y = L - 1;
                int sumL = 0;
                while (y < i) {
                    sumL = prefixSum[y + 1] - prefixSum[x];
                    x++;
                    y++;
                }

                int p = j + 1;
                int q = p + L - 1;
                while (q < len) {
                    sumL = prefixSum[q + 1] - prefixSum[p];
                    p++;
                    q++;
                }

                if (sumL > 0) {
                    int sumK = prefixSum[j + 1] - prefixSum[i];
                    result = Math.max(result, sumK + sumL);
                }
                i++;
                j++;
            }
            return result;
        }

//        public int solution3(int[] A, int K, int L) {
//            int result = -1;
//            for (int space = 0; space <= A.length - (K + L); space++) {
//                for (int start = 0; start <= A.length - (K + space + L); start++) {
//                    int startRight1 = start + K + space;
//                    int currentSum1 = sum(A, start, start + K - 1) + sum(A, startRight1, startRight1 + L - 1);
//                    result = Math.max(result, currentSum1);
//
//                    int startRight2 = start + L + space;
//                    int currentSum2 = sum(A, start, start + L - 1) + sum(A, startRight2, startRight2 + K - 1);
//                    result = Math.max(result, currentSum2);
//
//                    //System.out.println("space: " + space + ", start: " + start + ", currentSum1: " + currentSum1 + ", currentSum2: " + currentSum2);
//                }
//            }
//
//            return result;
//        }


        wydaje mi sie, ze jest rozwiazanie ze zlozonoscia N, co tak na oko zreszta ocenialbym po tresci zadania, ze to jest zlozonosc docelowa

        trzeba najpierw utworzyc tablice, w ktorej na indeksie i jest suma kolejnych K elementow (i analogiczna dla L)

        i potem na tej podstawie zrobic tablice maksimow sufiksowych, to znaczy na indeksie i jest liczba, ktora jest maksymalna wartoscia sposrod wszystkich podsum o dlugosci K zaczynajacych sie od pozycji i lub dalszej w prawo

        oblicza sie to idac po pierwszej tablicy od prawej strony i powiekszajac na kolejnym elemencie, jesli trzeba

        i wtedy mamy petle dajmy po indeksie "start" i suma calkowita dla tego indeksu to jest tablica_sum_K[start] + tablica_maks_sufix_L[start + K]

        i jeszcze tablica_sum_L[start] + tablica_maks_sufix_K[start + L]

        i mamy jeden przebieg po N




    }
}

