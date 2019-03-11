package com.tom.nr2_Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int[] solution = new Solution().solution(A, 3);
        System.out.println(Arrays.toString(solution));

    }

    public static class Solution {
        public int[] solution(int[] A, int K) {
            if (A.length == 0 || K == 0) {
                return A;
            }
            Deque<Integer> deque = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));
            for (int i = 0; i < K; i++) {
                int last = deque.removeLast();
                deque.addFirst(last);
            }
            return deque.stream().mapToInt(value -> value).toArray();
        }
    }
}