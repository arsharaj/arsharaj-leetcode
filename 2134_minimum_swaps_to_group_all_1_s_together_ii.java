// @lc app=leetcode id=2134 lang=java

class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        }
        int maxOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 1) {
                maxOnes++;
            }
        }
        int currOnes = maxOnes;
        int left = 0;
        int right = totalOnes - 1;
        int len = nums.length;
        while (left < len) {
            currOnes -= nums[(left++)];
            currOnes += nums[(++right) % len];
            maxOnes = Math.max(maxOnes, currOnes);
        }
        return totalOnes - maxOnes;
    }
}
