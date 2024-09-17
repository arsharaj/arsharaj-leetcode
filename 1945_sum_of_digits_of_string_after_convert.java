// @lc app=leetcode id=1945 lang=java

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder integers = new StringBuilder();
        for (char ch : s.toCharArray()) integers.append(ch - 'a' + 1);
        while (k-- > 0) {
            int sum = 0;
            for (char ch : integers.toString().toCharArray())
                sum += ch - '0';
            integers = new StringBuilder(String.valueOf(sum));
        }
        return Integer.parseInt(integers.toString());
    }
}
