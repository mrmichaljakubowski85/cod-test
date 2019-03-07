package com.tom.nr7_Brackets;

import java.util.*;


public class Brackets {
    public static void main(String[] args) {
        String s1 = "{[()()]}";
        int result1 = new Solution().solution(s1);
        System.out.println(result1);

        String s2 = "([)()]";
        int result2 = new Solution().solution(s2);
        System.out.println(result2);

    }

    public static class Solution {
        public int solution(String S) {
            if (S == null)
                return 0;
            if (S.isEmpty())
                return 1;
            Deque<Character> characterStack = new LinkedList<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                try {
                    switch (c) {
                        case ')':
                            pop(characterStack, '(');
                            break;
                        case '}':
                            pop(characterStack, '{');
                            break;
                        case ']':
                            pop(characterStack, '[');
                            break;
                        default:
                            characterStack.push(c);
                    }
                } catch (AssumptionUnfulfilledException e) {
                    return 0;
                }
            }
            return characterStack.isEmpty() ? 1 : 0;
        }

        private static void pop(Deque<Character> characterStack, char charToCompare) throws AssumptionUnfulfilledException {
            if (characterStack.size() == 0)
                throw new AssumptionUnfulfilledException();
            char charFromStack = characterStack.pop();
            if (charFromStack != charToCompare)
                throw new AssumptionUnfulfilledException();

        }

        private static class AssumptionUnfulfilledException extends Exception {

        }

    }
}
