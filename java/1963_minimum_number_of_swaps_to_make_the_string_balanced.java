/*

Problem : Minimum number of swaps to make the string balanced

Inputs :-
- s : string of opening and closing brackets of length n

Output :-
- integer : minimum number of swaps to make s balanced

Precondition for balanced string :-
- it is empty string
- can be written as AB where both A and B are balanced strings
- can be written as [C] where C is a balanced string

Thoughts :-
- using two pointer approach with a stack to make the string balanced
- watched the pattern in the question with even and odd length stackSize

*/

class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackSize++;
            } else if (stackSize > 0) {
                stackSize--;
            }
        }

        return (stackSize + 1) / 2;
    }
}