// @lc app=leetcode id=1894 lang=java

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long chalkSum = 0;
        for (int chalkPiece : chalk) chalkSum += chalkPiece;
        chalkSum = k % chalkSum;
        for (int i = 0; i < chalk.length; i++)
            if (chalkSum < chalk[i]) return i;
            else chalkSum -= chalk[i];
        return -1;
    }
}
