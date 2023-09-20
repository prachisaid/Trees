package Trees;

public class RecoverBST extends BinarySearchTree{
    Node first;
    Node prev;
    Node last;
    Node middle;

    private void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(prev != null && root.value < prev.value){
            if(first == null){
                first = prev;
                middle = root;
            }

            else{
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(Node root){
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);

        inorder(root);

        if(first != null && last != null){
            int d = first.value;
            first.value = last.value;
            last.value = d;
        }
        else if(first != null && middle != null){
            int d = first.value;
            first.value = middle.value;
            middle.value = d;
        }
    }
    public static void main(String[] args) {
        RecoverBST bst = new RecoverBST();

        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);
        bst.insert(1);
    }
}
