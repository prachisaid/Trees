package Trees;

import java.util.*;
import java.util.stream.Collectors;

public class ZigZagTraversal extends BinarySearchTree{
    public void zigzagLevelOrder(Node node) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = true;

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int level = queue.size();
            int[] arr = new int[level];

            for (int i = 0; i < level; i++) {
                Node n = queue.poll();

                int index = flag ? i : (level - 1 - i);
                arr[index] = n.value;

                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){

                    queue.add(n.right);
                }
            }
            flag = !flag;
            ans.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }

        System.out.println(ans);
    }
}
