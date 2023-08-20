package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeII {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int numsLeft = inEnd - inRoot;

        root.left = buildTree(postorder, postStart, postEnd - numsLeft - 1, inorder, inStart, inRoot - 1, map);
        root.right = buildTree(postorder, postEnd - numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, map);

        return root;
    }

    public static void main(String[] args) {
        ConstructTreeII tree = new ConstructTreeII();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(tree.buildTree(postorder, inorder).val);
    }
}
