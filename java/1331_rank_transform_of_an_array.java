/*
Problem :- Rank transform of an array
Input :-
- arr : array of integers
Output :-
- arr : array of integers
Preconditions :-
- rank starts from 1
- larger the element means larger the rank
- equal elements have same rank
- rank should be small as possible
Thoughts :-
- Use priority queue but i could not change the elements position
- What about priority hashmap where hashmap will give me the index
*/

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>(); // Value -> List of indices
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        int counter = 1;
        for (Integer key : map.keySet()) {
            for (int index : map.get(key)) {
                arr[index] = counter;
            }
            counter++;
        }
        return arr;
    }
}