/*
Problem : Divide intervals into minimum number of groups
Inputs :-
- intervals : 2d array of intervals with left[i] and right[i] value
Outputs :-
- integer : minimum number of groups
Thoughts :-
- calculate the maximum overlapping intervals
- overlapping intervals using line sweep algorithm
*/

class Solution {
    public int minGroups(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum value in interval
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }

        int[] overlaps = new int[max + 2];

        // Line sweep algorithm core logic
        for (int[] interval : intervals) {
            overlaps[interval[0]]++;
            overlaps[interval[1] + 1]--;
        }

        int groups = 0;

        // Find the maximum groups
        for (int i = 1; i < overlaps.length; i++) {
            overlaps[i] += overlaps[i - 1];
            groups = Math.max(groups, overlaps[i]);
        }

        return groups;
    }
}