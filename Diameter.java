package Trees;

import recursion.BinarySearch;

public class Diameter extends BinarySearchTree {
    public int diameterOfBinaryTree(Node node) {
//        int max = 0;
//        return findMax(node, max);
        int[] diameter = new int[1];
        dfsHeight(node, diameter);
        return diameter[0];
    }

    private int findMax(Node node, int max){
        if(node == null){
            return max;
        }

        int lh = dfsHeight(node.left);
        int rh = dfsHeight(node.right);

        max = Math.max(max, lh + rh);

        findMax(node.left, max);
        findMax(node.right, max);

        return max;
    }

    int dfsHeight(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int dfsHeight(Node root, int[] diameter){
        if(root == null){
            return 0;
        }

        int leftHeight = dfsHeight(root.left, diameter);
        int rightHeight = dfsHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
