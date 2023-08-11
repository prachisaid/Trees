package Trees;

import java.util.*;

public class RightView extends BinarySearchTree{
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

    public List<Integer> rightSideView(Node root) {
        Queue<QueueData> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, Node>> map = new TreeMap<>();

        queue.add(new QueueData(root, 0, 0));

        while(!queue.isEmpty()){
            QueueData q = queue.poll();

            map.put(q.level, new TreeMap<>());
            map.get(q.level).put(q.vertical, q.node);

            if(q.node.right != null){
                queue.add(new QueueData(q.node.right, q.vertical + 1, q.level + 1));
            }

            if(q.node.left != null){
                queue.add(new QueueData(q.node.left, q.vertical - 1, q.level + 1));
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for(TreeMap<Integer, Node> ys : map.values()){
            for(Node node : ys.values()){
                lst.add(node.value);
            }
        }

        return lst;
    }
}
