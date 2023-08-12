package Trees;

import java.util.*;

public class MaximumTimeToBurnTree extends BinarySearchTree{
    public int minTime(Node root, int t){
        Map<Node, Node> map = new HashMap<>();
        Node target = findParent(root, map, t);
        int maxi = findMaxDistance(map, target);

        return maxi;
    }

    private int findMaxDistance(Map<Node, Node> map, Node target) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();

        queue.add(target);
        visited.add(target);

        int maxi = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if(map.get(node) != null && !visited.contains(map.get(node))){
                    flag = 1;
                    visited.add(map.get(node));
                    queue.add(map.get(node));
                }

                if(node.left != null && !visited.contains(node.left)){
                    flag = 1;
                    visited.add(node.left);
                    queue.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    flag = 1;
                    visited.add(node.right);
                    queue.add(node.right);
                }

            }

            if(flag == 1){
                maxi++;
            }
        }

        return maxi;
    }

    private Node findParent(Node root, Map<Node, Node> map, int start){
        Queue<Node> queue = new LinkedList<>();
        Node res = new Node(-1);
        queue.add(root);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.value == start) res = n;

            if(n.left != null){
                queue.offer(n.left);
                map.put(n.left, n);
            }

            if(n.right != null){
                queue.offer(n.right);
                map.put(n.right, n);
            }
        }

        return res;
    }
}
