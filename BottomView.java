package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView extends BinarySearchTree{
    class QueueData{
        Node node;
        int vertical;

        QueueData(Node n, int v){
            this.node = n;
            this.vertical = v;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        Queue<QueueData> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        queue.add(new QueueData(root, 0));

        while(!queue.isEmpty()){
            QueueData q = queue.poll();

            map.put(q.vertical, q.node);

            if(q.node.left != null){
                queue.add(new QueueData(q.node.left, q.vertical - 1));
            }

            if(q.node.right != null){
                queue.add(new QueueData(q.node.right, q.vertical + 1));
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();

        for (Node node : map.values()){
            lst.add(node.value);
        }
        return lst;
    }
}
