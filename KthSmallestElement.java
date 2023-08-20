package Trees;

import java.util.ArrayList;

public class KthSmallestElement extends BinarySearchTree{
    public int key;
    public int kthSmallest(Node root, int k){
        int[] arr = new int[1];
        key = k;

        largest(root, arr);

        return arr[0];
    }

    private void inorder(Node root, int[] arr){
        if(root == null){
            return;
        }

        inorder(root.left, arr);
        key = key - 1;
        if(key == 0){
            arr[0] = root.value;
            return;
        }
        inorder(root.right, arr);
    }

    private void largest(Node root, int[] arr){
        if(root == null){
            return;
        }

        largest(root.right, arr);
        key = key - 1;
        if(key == 0){
            arr[0] = root.value;
            return;
        }
        largest(root.left, arr);
    }

    public static void main(String[] args) {
        KthSmallestElement bst = new KthSmallestElement();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.kthSmallest(bst.root, 3));
    }
}
