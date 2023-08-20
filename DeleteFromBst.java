package Trees;

public class DeleteFromBst extends BinarySearchTree{
    public Node deleteNode(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.value == key){
            return helper(root);
        }

        Node temp = root;

        while(root != null){
            if(root.value > key){
                if(root.left != null && root.left.value == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }

            else{
                if(root.right != null && root.right.value == key){
                    root.right = helper(root.right);
                }
                else{
                    root = root.right;
                }
            }
        }

        return temp;
    }

    private Node helper(Node root) {
        if(root.left == null) return root.right;

        if(root.right == null) return root.left;

        Node rightChild = root.right;
        Node lastRightChild = findLastRightChild(root.left);

        lastRightChild.right = rightChild;
        return root.left;
    }

    private Node findLastRightChild(Node left) {
        if(left.right == null) return left;

        return findLastRightChild(left.right);
    }

    public static void main(String[] args) {
        DeleteFromBst bst = new DeleteFromBst();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.deleteNode(bst.root, 6).value);
    }
}
