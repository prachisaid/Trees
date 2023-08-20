package Trees;

public class FindCeil extends BinarySearchTree{
    int findCeil(Node root, int key) {
        if (root == null) return -1;

        int ans = Integer.MAX_VALUE;

        while(root != null){
            if(root.value == key) {
                return root.value;
            }
            else if(root.value > key && root.value < ans){
                ans = root.value;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindCeil bst = new FindCeil();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);

        System.out.println(bst.findCeil(bst.root, 5));
    }
}
