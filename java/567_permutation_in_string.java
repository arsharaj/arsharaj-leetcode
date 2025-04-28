/*
Problem : Permutation in String
Inputs :-
- s1 : string
- s2 : string
Output :-
- boolean : check if s2 contains any permutation of s1
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        if (isMatched(s1Map, s2Map)) {
            return true;
        }

        for (int i = 1; i < s2Len - s1Len + 1; i++) {
            s2Map[s2.charAt(i - 1) - 'a']--;
            s2Map[s2.charAt(i + s1Len - 1) - 'a']++;

            if (isMatched(s1Map, s2Map)) {
                return true;
            }
        }

        return false;
    }

    private boolean isMatched(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }

        return true;
    }
}