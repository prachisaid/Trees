package Trees;

public class Symmetrical extends BinarySearchTree{
    public boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }

        return check(root.left, root.right);
    }

    private boolean check(Node left, Node right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.value != right.value){
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);

    }
}
