package Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + 1 + numsLeft, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }

    public static void main(String[] args) {
        ConstructTree tree = new ConstructTree();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        Node root = tree.buildTree(inorder, preorder);
        System.out.println(root.val);
    }
}
