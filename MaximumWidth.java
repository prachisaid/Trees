package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth extends BinarySearchTree{

    class Pair{
        Node node;
        int num;

        Pair(Node node, int n){
            this.node = node;
            this.num = n;
        }
    }
    public int widthOfBinaryTree(Node root) {
        if(root == null) return 0;

        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curr_id = queue.peek().num - min;
                Node node = queue.peek().node;
                queue.poll();

                if(i == 0) first = curr_id;
                if(i == size-1) last = curr_id;

                if(node.left != null){
                    queue.add(new Pair(node.left, curr_id * 2 + 1));
                }

                if(node.right != null){
                    queue.add(new Pair(node.right, curr_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
