package Trees;

public class SearchBST extends BinarySearchTree{
    public Node searchBST(Node root, int val) {
        if(root.value == val){
            return root;
        }

        if(root.value > val) return searchBST(root.left, val);

        if(root.value < val) return searchBST(root.right, val);

        return null;
    }

    public static void main(String[] args) {
        SearchBST bst = new SearchBST();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.searchBST(bst.root, 7).value);
    }
}
