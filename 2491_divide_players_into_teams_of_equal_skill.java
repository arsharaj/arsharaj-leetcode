/*
Problem : Divide players into teams of equal skill
Input :-
- skill : positive integer array of even length n
Given :-
- skills is an even array
- skills[i] denotes the skill of ith player
- create n / 2 pairs of size 2 such that the total skill of each team is equal
- chemistry = product of skills of both players
Output :-
- chemistry or -1 : -1 of there is no way to divide players into pairs
Thoughts :-
- sort the skill array and then use two pointer approach
*/

import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int start = 0;
        int end = skill.length - 1;
        long chemistry = 0;
        int sum = skill[start] + skill[end];
        
        while (start < end) {
            if (skill[start] + skill[end] != sum) {
                return -1;
            }
            
            chemistry += skill[start++] * skill[end--];
        }

        return chemistry;
    }
}