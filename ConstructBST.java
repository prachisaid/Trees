package Trees;

public class ConstructBST extends BinarySearchTree{
    public Node bstFromPreorder(int[] preorder) {
        Node root = null;
        for(int i = 0; i < preorder.length; i++){
            root = insert(preorder[i], root);
        }
        return root;
    }

    private Node insert(int val, Node root){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val > root.value){
            root.right = insert(val, root.right);
        }
        else{
            root.left = insert(val, root.left);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        ConstructBST bst = new ConstructBST();

        Node root = bst.bstFromPreorder(preorder);
        System.out.println(root.value);
    }
}
