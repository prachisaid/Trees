package Trees;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        bst.insert(15);
        bst.insert(10);
        bst.insert(12);
        bst.insert(15);
        bst.insert(13);
        bst.insert(20);
        bst.insert(11);
//        bst.insert(16);
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        bst.populateSorted(nums);
//        bst.display();
        bst.inorder();
//        System.out.println(bst.balance());
    }

}
