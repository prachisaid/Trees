package Trees;

import java.util.Arrays;

public class ConstructTree {
    class Node{
        Node left;
        Node right;
        int val;

        Node(int val){
            this.val = val;
        }
    }

    public Node buildTree(int[] preorder, int[] inorder) {
        Node root = new Node(-1);
        construct(preorder, inorder, root);

        return root;
    }

    private void construct(int[] preorder, int[] inorder, Node root){
        if(preorder.length == 0 && inorder.length == 0){
            return;
        }

        root = new Node(preorder[0]);
        int ind = 0;

        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                ind = i;
            }
        }

        construct(Arrays.copyOfRange(preorder, 0, 1), Arrays.copyOfRange(inorder, 0, ind), root.left);
        construct(Arrays.copyOfRange(preorder, 0, 1), Arrays.copyOfRange(inorder, ind + 1, inorder.length), root.right);
    }
}
