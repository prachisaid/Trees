package Trees;

import java.util.*;

public class TopView extends BinarySearchTree{

    class QueueData{
        Node node;
        int vertical;

        public QueueData(Node n, int v){
            this.node = n;
            this.vertical = v;
        }
    }
    public ArrayList<Integer> topView(Node root){
        Queue<QueueData> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        queue.add(new QueueData(root, 0));

        while(!queue.isEmpty()){
            Map<Node, Integer> temp = new HashMap<>();
            QueueData q = queue.remove();

            if(!map.containsKey(q.vertical)){
                map.put(q.vertical, q.node);
            }

            if(q.node.left != null){
                queue.add(new QueueData(q.node.left, q.vertical - 1));
            }

            if(q.node.right != null){
                queue.add(new QueueData(q.node.right, q.vertical + 1));
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for(Node node : map.values()){
            lst.add(node.value);
        }

        return lst;
    }
}
