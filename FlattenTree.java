package Trees;

public class FlattenTree  extends BinarySearchTree{
    Node prev = null;
    public void flatten(Node root) {
        if(root == null) return;
        flatten1(root);
    }

    public void flatten1(Node root){
        if(root == null) return;

        flatten1(root.right);
        flatten1(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    public static void main(String[] args) {
        FlattenTree bst = new FlattenTree();
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        bst.flatten(bst.root);
        System.out.println(bst.root.right.value);
    }
}
