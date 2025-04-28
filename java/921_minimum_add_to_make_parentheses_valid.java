/*
Problem : Minimum add to make parentheses valid
Inputs :-
- s : string of opening and closing parenthesis
Outputs :-
- integer : minimum number of moves to make s valid
Thoughts :-
- use some kind of stack to keep track of opening and respective closing parenthesis
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // To count open brackets that are not closed
        int closed = 0; // To count closed brackets that are not open

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Open parenthesis condition
                open++;
            } else if (open > 0) {
                // Closed parenthesis condition with open parenthesis
                open--;
            } else {
                // Closed parenthesis condition with no open parenthesis
                closed++;
            }
        }

        return open + closed;
    }
}