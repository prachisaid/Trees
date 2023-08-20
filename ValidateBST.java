package Trees;

import java.util.ArrayList;

public class ValidateBST extends BinarySearchTree{
    public boolean isValidBST(Node root){
        if(root == null) return true;
        ArrayList<Integer> lst = new ArrayList<>();
        helper(root, lst);
        boolean flag = true;

        for (int i = 0; i < lst.size() - 1; i++) {
            if(lst.get(i) > lst.get(i + 1)){
                flag = false;
            }
        }

        return flag;
    }

    private void helper(Node root, ArrayList<Integer> lst){
        if(root == null){
            return;
        }

        helper(root.left, lst);
        lst.add(root.value);
        helper(root.right, lst);
    }

    public boolean isValidBST(Node root, long minVal, long maxVal){
        if(root == null) return true;

        if(root.value >= maxVal || root.value <= minVal) return false;

        // lesser than this && greater than this
        return isValidBST(root.left, minVal, root.value) && isValidBST(root.right, root.value, maxVal);
    }

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.isValidBST(bst.root));
    }
}
