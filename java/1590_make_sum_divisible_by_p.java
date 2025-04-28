/*
Problem : Make Sum Divisible by P
Inputs :-
- nums : array of positive integers
Output :-
- length of the smallest subarray otherwise -1
Preconditions :-
- remove the smallest subarray
- subarray is contiguous block of elements in the array
- smallest subarray could be empty
- sum of remaining elements should be divisible by p
- not allowed to remove the whole array
*/

import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;

        for (int num : nums) {
            sum = sum % p + num % p;
        }

        int target = sum % p;
        
        if (target == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // cumulative sum -> index
        int curr = 0;
        map.put(curr, -1);
        int result = nums.length;
        
        for (int j = 0; j < nums.length; j++) {
            curr = (curr + nums[j]) % p;
            if (map.containsKey((curr - target + p) % p)) {
                int i = map.get((curr - target + p) % p);
                result = Math.min(result, j - i);
            }
            map.put(curr, j);
        }

        return result == nums.length ? -1 : result;
    }
}