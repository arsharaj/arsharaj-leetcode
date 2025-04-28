/*

Problem : Maximal score after applying k operations

Inputs :-
- nums : positive integer array
- k : number of operations allowed

Outputs :-
- long : maximum score possible after applying k operations

Thoughts :-
- priority queue seems to be the right way

*/

import java.util.PriorityQueue;;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);
        }

        long score = 0;

        while (k != 0) {
            int val = pq.poll();
            score += val;
            pq.offer((val + 2) / 3);
            k--;
        }

        return score;
    }
}