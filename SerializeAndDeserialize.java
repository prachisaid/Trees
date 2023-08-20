package Trees;

import java.util.*;

public class SerializeAndDeserialize extends BinarySearchTree{
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        Queue<Node> queue = new LinkedList<>();
        String str = "";

        queue.add(root);

        while(!queue.isEmpty()){
            if(root == null){
                return "null";
            }

            Node node = queue.remove();
            if(node == null){
                str += "null,";
            }
            else {
                str += node.value + ",";
            }

            if(node != null){
                if(node.left != null){
                    queue.add(node.left);
                }
                else{
                    queue.add(null);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
                else{
                    queue.add(null);
                }
            }
        }

        return str;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0 || data == "null"){
            return null;
        }

        String[] arr = data.split(",");
        Queue<Node> queue = new LinkedList<>();

        Node newRoot = new Node(Integer.parseInt(arr[0]));
        queue.add(newRoot);
        int i = 1;

        while(!queue.isEmpty()){
            Node node = queue.remove();

            if(i < arr.length && !Objects.equals(arr[i], "null")){
                node.left = new Node(Integer.parseInt(arr[i]));
                queue.add(node.left);
            }else{
                node.left = null;
            }

            if(i < arr.length && !Objects.equals(arr[i + 1], "null")){
                node.right = new Node(Integer.parseInt(arr[i + 1]));
                queue.add(node.right);
            }else{
                node.right = null;
            }

            i += 2;
        }

        return newRoot;
    }

    public static void main(String[] args) {
        SerializeAndDeserialize bst = new SerializeAndDeserialize();
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        bst.inorder();
        bst.preorder();
        System.out.println(bst.serialize(bst.root));
        System.out.println(bst.deserialize(bst.serialize(bst.root)).left.value);
    }
}
