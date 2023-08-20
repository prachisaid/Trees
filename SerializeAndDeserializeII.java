package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeII extends BinarySearchTree{
    public String serialize(Node root){
        if(root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node == null){
                res.append("#,");
                continue;
            }

            res.append(node.value + ",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return res.toString();
    }

    public Node deserialize(String data){
        if(data == "") return null;

        Queue<Node> queue = new LinkedList<>();
        String[] values = data.split(",");

        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            Node parent = queue.poll();

            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeII bst = new SerializeAndDeserializeII();
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.serialize(bst.root));
        System.out.println(bst.deserialize(bst.serialize(bst.root)).left.value);
    }
}
