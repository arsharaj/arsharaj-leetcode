/*
Problem : Maximum width ramp
Inputs :-
- nums : positive integer array
Outputs :-
- integer : maximum width of ramp else 0
Given :-
- ramp : pair(i, j) such that i < j and nums[i] <= nums[j]
Thoughts :-
- sort on the basis of value and keep the track of index
- using a monotonic stack in strictly decreasing order
*/

import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> monoStack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (monoStack.isEmpty() || nums[monoStack.peek()] > nums[i]) {
                monoStack.push(i);
            }
        }
        
        int width = 0;
        
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!monoStack.isEmpty() && nums[j] >= nums[monoStack.peek()]) {
                width = Math.max(width, j - monoStack.pop());
            }

            if (monoStack.isEmpty()) {
                break;
            }
        }
        
        return width;
    }
}