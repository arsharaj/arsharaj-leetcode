import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        if (a > 0) {
            pq.add(new Pair('a', a));
        }
        if (b > 0) {
            pq.add(new Pair('b', b));
        }
        if (c > 0) {
            pq.add(new Pair('c', c));
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            char currChar = pq.peek().ch;
            int currCount = pq.peek().count;
            pq.poll();
            int resLen = res.length();

            if (resLen > 1 && res.charAt(resLen - 1) == currChar && res.charAt(resLen - 2) == currChar) {
                if (pq.isEmpty()) {
                    break;
                }

                char nextChar = pq.peek().ch;
                int nextCount = pq.peek().count;
                pq.poll();
                res.append(nextChar);
                nextCount--;
                
                if (nextCount > 0) {
                    pq.offer(new Pair(nextChar, nextCount));
                }
            } else {
                res.append(currChar);
                currCount--;
            }

            if (currCount > 0) {
                pq.offer(new Pair(currChar, currCount));
            }
        }

        return res.toString();
    }
}

class Pair implements Comparable<Pair> {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    public int compareTo(Pair that) {
        return that.count - this.count;
    }
}