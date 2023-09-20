package Trees;
public class InorderSuccessor extends BinarySearchTree{
    Node inorderSuccessor(Node root, Node p){
        Node successor = null;
        String str = "AB";
        String subStr = str.substring(0, 3);


        while(root != null){
            if(p.value < root.value){
                successor = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }

        return successor;
    }
    public static void main(String[] args) {
        InorderSuccessor bst = new InorderSuccessor();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);
        bst.insert(1);

        System.out.println(bst.inorderSuccessor(bst.root, bst.root.left.left).value);
    }
}
