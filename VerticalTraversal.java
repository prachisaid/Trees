package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalTraversal extends BinarySearchTree{
    class QueueData{
        Node node;
        int vertical;
        int level;

        QueueData(Node n, int v, int l){
            this.node = n;
            this.vertical = v;
            this.level = l;
        }
    }
    public void verticalTraversal(Node node) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<QueueData> queue = new LinkedList<>();
        queue.add(new QueueData(node, 0, 0));

        while(!queue.isEmpty()){
            QueueData q = queue.poll();

            if(!map.containsKey(q.vertical)){
                map.put(q.vertical, new TreeMap<>());
            }

            if(!map.get(q.vertical).containsKey(q.level)){
                map.get(q.vertical).put(q.level, new PriorityQueue<>());
            }

            map.get(q.vertical).get(q.level).offer(q.node.value);

            if(q.node.left != null){
                queue.add(new QueueData(q.node.left, q.vertical - 1, q.level + 1));
            }

            if(q.node.right != null){
                queue.add(new QueueData(q.node.right, q.vertical + 1, q.level + 1));
            }

        }

        System.out.println(map);
        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            ans.add(new ArrayList<>());

            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        System.out.println(ans);
    }

    private void inOrder(Node node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(node == null){
            return;
        }

        inOrder(node.left, x - 1, y + 1, map);
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }

        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(node.value);
        inOrder(node.right, x + 1, y + 1, map);
    }

    public void vertical(Node root){
        if(root == null){
            return;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        inOrder(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size() - 1).add(pq.poll());
                }
            }
        }

        System.out.println(ans);
    }
}
