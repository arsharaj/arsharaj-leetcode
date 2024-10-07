/*
Problem : Minimum string length after removing substrings
Inputs :-
- s : string of only uppercase english letters
Outputs :-
- len : minimum possible length of the resulting string
Thoughts :-
- Solve the question using a stack
*/

import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char top = stack.peek();

            if ((ch == 'B' && top == 'A') || (ch == 'D' && top == 'C')) {
                stack.pop();
                continue;
            }

            stack.push(ch);
        }

        return stack.size();
    }
}