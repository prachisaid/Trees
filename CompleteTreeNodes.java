package Trees;

public class CompleteTreeNodes extends BinarySearchTree{
    public int countNodes(Node root) {
        if(root == null) return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right) {
            return (2 << left) - 1;
        }

        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftHeight(Node root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }

        return count;
    }

    private int getRightHeight(Node root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }

        return count;
    }

}
