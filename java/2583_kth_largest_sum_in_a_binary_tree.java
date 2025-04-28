import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;


class Solution {

    ArrayList<Long> sums = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        
        queue.add(root);

        bfs();

        Collections.sort(sums, Collections.reverseOrder());

        return k > sums.size() ? -1 : sums.get(k - 1);
    }

    void bfs() {
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            sums.add(sum);
        }
    }
}
