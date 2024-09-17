import java.util.HashMap;
import java.util.stream.IntStream;

class UnionFind {
    private int[] id;
    private int[] size;
    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        if (proot == qroot) return;
        if (size[proot] < size[qroot]) {
            id[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            id[qroot] = proot;
            size[proot] += size[qroot];
        }
    }
    public int getMaxRank() {
        return IntStream.of(size).max().orElse(0);
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>(); // num -> index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                continue;
            if (map.containsKey(nums[i] - 1))
                uf.union(i, map.get(nums[i] - 1));
            if (map.containsKey(nums[i] + 1))
                uf.union(i, map.get(nums[i] + 1));
            map.put(nums[i], i);
        }
        return uf.getMaxRank();
    }
}