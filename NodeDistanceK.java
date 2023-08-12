package Trees;

import java.util.*;

public class NodeDistanceK extends BinarySearchTree{
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> map = findParent(root);
        List<Integer> lst = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();

        queue.add(target);
        visited.add(target);
        int diff = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(diff == k) break;
            diff++;

            for (int i = 0; i < size; i++) {
//                boolean up = false, l = false, r = false;
                Node node = queue.poll();

                if(map.get(node) != null && !visited.contains(map.get(node))){
//                    up = true;
                    visited.add(map.get(node));
                    queue.add(map.get(node));
                }

                if(node.left != null && !visited.contains(node.left)){
//                    l = true;
                    visited.add(node.left);
                    queue.add(node.right);
                }

                if(node.right != null && !visited.contains(node.right)){
//                    r = true;
                    visited.add(node.right);
                    queue.add(node.right);
                }

//                if(up || l || r){
//                    diff++;
//                }
            }
        }

        while(!queue.isEmpty()){
            lst.add(queue.poll().value);
        }

        return lst;
    }

    private Map<Node, Node> findParent(Node root){
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(n.left != null){
                queue.offer(n.left);
                map.put(n.left, n);
            }

            if(n.right != null){
                queue.offer(n.right);
                map.put(n.right, n);
            }
        }

        return map;
    }
}
